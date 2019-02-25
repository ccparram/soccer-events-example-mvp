package com.examples.soccerevents.ui.base;

import com.examples.soccerevents.R;
import com.examples.soccerevents.data.network.model.ApiError;
import com.examples.soccerevents.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView, I extends MvpInteractor>
        implements MvpPresenter<V, I> {

    private static final String TAG = "BasePresenter";

    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    private V mMvpView;
    private I mMvpInteractor;

    @Inject
    public BasePresenter(I mvpInteractor,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        mMvpInteractor = mvpInteractor;
        mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
        mMvpInteractor = null;
    }

    @Override
    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public I getInteractor() {
        return mMvpInteractor;
    }

    @Override
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    @Override
    public void checkViewAttached() throws MvpViewNotAttachedException {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void handleApiError(Throwable error) {

        if (error == null) {
            getMvpView().onError(R.string.error_api_unknown);
            return;
        }

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        try {
            if(error instanceof HttpException) {
                ResponseBody body = ((HttpException) error).response().errorBody();
                String bodyString = null;
                if (body != null) {
                    bodyString = body.string();
                }

                ApiError apiError = gson.fromJson(bodyString, ApiError.class);

                if (apiError == null || apiError.getMessage() == null) {
                    getMvpView().onError(R.string.error_api_unknown);
                }
                else {
                    getMvpView().onError(apiError.getMessage());
                }

            } else {
                throw new IOException(error);
            }
        }
        catch (IOException e){
            Logger.e("UnknownHostException: " + e);
            getMvpView().showMessage(R.string.error_api_lost_connection);
        }
        catch (Exception e) {
            Logger.e("Exception: " + e);
            getMvpView().showMessage(R.string.error_api_unknown);
        }
    }


    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}

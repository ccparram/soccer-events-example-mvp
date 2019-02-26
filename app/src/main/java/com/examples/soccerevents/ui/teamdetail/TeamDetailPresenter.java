package com.examples.soccerevents.ui.teamdetail;

import com.examples.soccerevents.ui.base.BasePresenter;
import com.examples.soccerevents.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TeamDetailPresenter<V extends TeamDetailMvpView, I extends TeamDetailMvpInteractor>
        extends BasePresenter<V, I> implements TeamDetailMvpPresenter<V, I> {


    @Inject
    public TeamDetailPresenter(I mvpInteractor,
                               SchedulerProvider schedulerProvider,
                               CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String teamId) {

        getMvpView().showLoading();

        getCompositeDisposable().add(getInteractor()
                .getEventsByTeam(teamId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe((teamEventsResponse) -> {
                    if(teamEventsResponse != null && teamEventsResponse.getEvents() != null){
                        getMvpView().showTeamDetail(teamEventsResponse.getEvents());
                    }
                    getMvpView().hideLoading();
                }, (throwable) -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                    handleApiError(throwable);
                }));
    }
}
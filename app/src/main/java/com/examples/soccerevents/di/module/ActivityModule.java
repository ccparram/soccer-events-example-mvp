package com.examples.soccerevents.di.module;

import android.content.Context;


import com.examples.soccerevents.di.ActivityContext;
import com.examples.soccerevents.di.PerActivity;
import com.examples.soccerevents.ui.citation.CitationInteractor;
import com.examples.soccerevents.ui.citation.CitationMvpInteractor;
import com.examples.soccerevents.ui.citation.CitationMvpPresenter;
import com.examples.soccerevents.ui.citation.CitationMvpView;
import com.examples.soccerevents.ui.citation.CitationPresenter;
import com.examples.soccerevents.ui.intro.IntroInteractor;
import com.examples.soccerevents.ui.intro.IntroMvpInteractor;
import com.examples.soccerevents.ui.intro.IntroMvpPresenter;
import com.examples.soccerevents.ui.intro.IntroMvpView;
import com.examples.soccerevents.ui.intro.IntroPresenter;
import com.examples.soccerevents.utils.rx.AppSchedulerProvider;
import com.examples.soccerevents.utils.rx.SchedulerProvider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}

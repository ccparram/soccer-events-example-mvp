package com.examples.soccerevents.di.module;

import android.content.Context;


import com.examples.soccerevents.di.ActivityContext;
import com.examples.soccerevents.di.PerActivity;
import com.examples.soccerevents.ui.teamdetail.TeamDetailInteractor;
import com.examples.soccerevents.ui.teamdetail.TeamDetailMvpInteractor;
import com.examples.soccerevents.ui.teamdetail.TeamDetailMvpPresenter;
import com.examples.soccerevents.ui.teamdetail.TeamDetailMvpView;
import com.examples.soccerevents.ui.teamdetail.TeamDetailPresenter;
import com.examples.soccerevents.ui.teamlist.TeamListInteractor;
import com.examples.soccerevents.ui.teamlist.TeamListMvpInteractor;
import com.examples.soccerevents.ui.teamlist.TeamListMvpPresenter;
import com.examples.soccerevents.ui.teamlist.TeamListMvpView;
import com.examples.soccerevents.ui.teamlist.TeamListPresenter;
import com.examples.soccerevents.utils.rx.AppSchedulerProvider;
import com.examples.soccerevents.utils.rx.SchedulerProvider;

import androidx.appcompat.app.AppCompatActivity;
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


    @Provides
    @PerActivity
    TeamListMvpPresenter<TeamListMvpView, TeamListMvpInteractor> provideTeamListPresenter(
            TeamListPresenter<TeamListMvpView, TeamListMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TeamListMvpInteractor provideTeamListMvpInteractor(TeamListInteractor interactor) {
        return interactor;
    }

    @Provides
    TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor> provideTeamDetailPresenter(
            TeamDetailPresenter<TeamDetailMvpView, TeamDetailMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TeamDetailMvpInteractor provideTeamDetailMvpInteractor(TeamDetailInteractor interactor) {
        return interactor;
    }
}

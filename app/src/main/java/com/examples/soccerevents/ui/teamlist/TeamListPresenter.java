package com.examples.soccerevents.ui.teamlist;

import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.ui.base.BasePresenter;
import com.examples.soccerevents.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TeamListPresenter<V extends TeamListMvpView, I extends TeamListMvpInteractor>
        extends BasePresenter<V, I> implements TeamListMvpPresenter<V, I> {

    @Inject
    public TeamListPresenter(I mvpInteractor,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String leagueName) {
        getMvpView().showLoading();

        getCompositeDisposable().add(getInteractor()
                .getTeamsByLeague(leagueName)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe((leagueTeamsResponse) -> {
                    if(leagueTeamsResponse != null && leagueTeamsResponse.getTeams() != null){
                        getMvpView().updateTeams(leagueTeamsResponse.getTeams());
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

    @Override
    public void onClickItemTeam(Team team) {
        if (isViewAttached()) {
            getMvpView().showTeamDetail(team);
        }
    }
}

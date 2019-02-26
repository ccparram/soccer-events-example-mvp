package com.examples.soccerevents.ui.teamlist;


import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.di.PerActivity;
import com.examples.soccerevents.ui.base.MvpPresenter;

@PerActivity
public interface TeamListMvpPresenter<V extends TeamListMvpView,
        I extends TeamListMvpInteractor> extends MvpPresenter<V, I> {

    void onViewPrepared(String leagueName);

    void onClickItemTeam(Team team);
}

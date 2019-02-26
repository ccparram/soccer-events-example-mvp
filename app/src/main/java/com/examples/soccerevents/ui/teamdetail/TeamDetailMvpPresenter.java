package com.examples.soccerevents.ui.teamdetail;


import com.examples.soccerevents.di.PerActivity;
import com.examples.soccerevents.ui.base.MvpPresenter;

@PerActivity
public interface TeamDetailMvpPresenter<V extends TeamDetailMvpView,
        I extends TeamDetailMvpInteractor> extends MvpPresenter<V, I> {

    void onViewPrepared(String teamId);
}
package com.examples.soccerevents.ui.teamlist;

import com.examples.soccerevents.data.network.ApiHelper;
import com.examples.soccerevents.data.network.model.LeagueTeamsResponse;
import com.examples.soccerevents.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class TeamListInteractor extends BaseInteractor
        implements TeamListMvpInteractor {

    @Inject
    public TeamListInteractor(ApiHelper apiHelper) {
        super(apiHelper);
    }

    @Override
    public Single<LeagueTeamsResponse> getTeamsByLeague(String leagueName) {
        return getApiHelper().getTeamsByLeague(leagueName);
    }
}
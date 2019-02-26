package com.examples.soccerevents.ui.teamdetail;


import com.examples.soccerevents.data.network.ApiHelper;
import com.examples.soccerevents.data.network.model.TeamEventsResponse;
import com.examples.soccerevents.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class TeamDetailInteractor extends BaseInteractor
        implements TeamDetailMvpInteractor {

    @Inject
    public TeamDetailInteractor(ApiHelper apiHelper) {
        super(apiHelper);
    }

    @Override
    public Single<TeamEventsResponse> getEventsByTeam(String teamId) {
        return getApiHelper().getEventsByTeam(teamId);
    }
}
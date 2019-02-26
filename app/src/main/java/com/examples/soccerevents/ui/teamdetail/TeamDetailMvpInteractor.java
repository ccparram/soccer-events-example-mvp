package com.examples.soccerevents.ui.teamdetail;


import com.examples.soccerevents.data.network.model.TeamEventsResponse;
import com.examples.soccerevents.ui.base.MvpInteractor;

import io.reactivex.Single;

public interface TeamDetailMvpInteractor extends MvpInteractor {

    Single<TeamEventsResponse> getEventsByTeam(String teamId);

}
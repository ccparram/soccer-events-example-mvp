package com.examples.soccerevents.ui.teamlist;


import com.examples.soccerevents.data.network.model.LeagueTeamsResponse;
import com.examples.soccerevents.ui.base.MvpInteractor;

import io.reactivex.Single;

public interface TeamListMvpInteractor extends MvpInteractor {

    Single<LeagueTeamsResponse> getTeamsByLeague(String leagueName);

}
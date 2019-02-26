package com.examples.soccerevents.data.network;

import com.examples.soccerevents.data.network.model.LeagueTeamsResponse;
import com.examples.soccerevents.data.network.model.TeamEventsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("search_all_teams.php")
    Single<LeagueTeamsResponse> getTeamsByLeague(@Query("l") String leagueName);

    @GET("eventsnext.php")
    Single<TeamEventsResponse> getEventsByTeam(@Query("id") String teamId);

}

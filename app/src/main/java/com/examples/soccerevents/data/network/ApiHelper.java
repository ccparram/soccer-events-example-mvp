package com.examples.soccerevents.data.network;

import com.examples.soccerevents.data.network.model.LeagueTeamsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("search_all_teams.php")
    Single<LeagueTeamsResponse> getTeamsByLeague(@Query("l") String leagueName);

}

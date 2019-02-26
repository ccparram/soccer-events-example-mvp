package com.examples.soccerevents.data.network.model;

import com.examples.soccerevents.data.database.model.Team;

import java.util.List;

public class LeagueTeamsResponse {

    private List<Team> teams;

    public LeagueTeamsResponse(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }
}

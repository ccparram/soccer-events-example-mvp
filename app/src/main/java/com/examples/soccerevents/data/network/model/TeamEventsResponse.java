package com.examples.soccerevents.data.network.model;

import com.examples.soccerevents.data.database.model.TeamEvent;

import java.util.List;

public class TeamEventsResponse {

    private List<TeamEvent> events;

    public TeamEventsResponse(List<TeamEvent> events) {
        this.events = events;
    }

    public List<TeamEvent> getEvents() {
        return events;
    }
}

package com.examples.soccerevents.data.database.model;

import com.google.gson.annotations.SerializedName;

public class TeamEvent {

    @SerializedName("idEvent")
    private String id;

    @SerializedName("strEvent")
    private String name;

    @SerializedName("strDate")
    private String date;

    public TeamEvent(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}

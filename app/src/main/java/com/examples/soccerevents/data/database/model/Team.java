package com.examples.soccerevents.data.database.model;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("idTeam")
    private String id;

    @SerializedName("strTeam")
    private String name;

    @SerializedName("strStadium")
    private String stadium;

    @SerializedName("strTeamBadge")
    private String badgeUrl;

    @SerializedName("strDescriptionEN")
    private String description;

    @SerializedName("intFormedYear")
    private String foundationYear;

    @SerializedName("strTeamJersey")
    private String jersey;

//  TODO: Add event list

    @SerializedName("strWebsite")
    private String website;

    @SerializedName("strFacebook")
    private String facebook;

    @SerializedName("strTwitter")
    private String twitter;

    @SerializedName("strInstagram")
    private String instagram;

    public Team(String id, String name, String stadium, String badgeUrl, String description, String foundationYear, String jersey, String website, String facebook, String twitter, String instagram) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.badgeUrl = badgeUrl;
        this.description = description;
        this.foundationYear = foundationYear;
        this.jersey = jersey;
        this.website = website;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStadium() {
        return stadium;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public String getJersey() {
        return jersey;
    }

    public String getWebsite() {
        return website;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getInstagram() {
        return instagram;
    }
}

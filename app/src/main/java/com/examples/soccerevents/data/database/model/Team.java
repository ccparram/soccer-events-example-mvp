package com.examples.soccerevents.data.database.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.stadium);
        dest.writeString(this.badgeUrl);
        dest.writeString(this.description);
        dest.writeString(this.foundationYear);
        dest.writeString(this.jersey);
        dest.writeString(this.website);
        dest.writeString(this.facebook);
        dest.writeString(this.twitter);
        dest.writeString(this.instagram);
    }

    protected Team(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.stadium = in.readString();
        this.badgeUrl = in.readString();
        this.description = in.readString();
        this.foundationYear = in.readString();
        this.jersey = in.readString();
        this.website = in.readString();
        this.facebook = in.readString();
        this.twitter = in.readString();
        this.instagram = in.readString();
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}

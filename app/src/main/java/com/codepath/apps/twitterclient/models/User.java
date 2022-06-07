package com.codepath.apps.twitterclient.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    private String name;
    private String screenName;
    private String profileImageUrl;

    public User(String name, String screenName, String profileImageUrl) {
        this.name = name;
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
    }

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        return new User(jsonObject.getString("name"),
                jsonObject.getString("screen_name"),
                jsonObject.getString("profile_image_url_https"));
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}

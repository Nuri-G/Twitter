package com.codepath.apps.twitterclient.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    String body;
    String createdAt;
    User user;

    // Needed for Parceler library
    public Tweet() {}

    public Tweet(String body, String createdAt, User user) {
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
    }

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        return new Tweet(jsonObject.getString("text"),
                jsonObject.getString("created_at"),
                User.fromJson(jsonObject.getJSONObject("user")));
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;

    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }
}

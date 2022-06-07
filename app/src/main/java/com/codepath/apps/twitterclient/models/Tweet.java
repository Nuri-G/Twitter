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
    String mediaUrl;

    // Needed for Parceler library
    public Tweet() {}

    public Tweet(String body, String createdAt, User user, String mediaUrl) {
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
        this.mediaUrl = mediaUrl;
    }

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        String mediaUrl = "";
        if(jsonObject.getJSONObject("entities").has("media")) {
            JSONArray media = jsonObject.getJSONObject("entities").getJSONArray("media");
            if(media.length() > 0) {
                mediaUrl = media.getJSONObject(0).getString("media_url");
            }
        }

        return new Tweet(jsonObject.getString("text"),
                jsonObject.getString("created_at"),
                User.fromJson(jsonObject.getJSONObject("user")),
                mediaUrl);
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

    public String getMediaUrl() {
        return mediaUrl;
    }
}

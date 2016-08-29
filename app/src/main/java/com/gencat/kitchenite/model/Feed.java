package com.gencat.kitchenite.model;

/**
 * Created by Tifani on 8/28/2016.
 */
public abstract class Feed {
    public static final String RECIPE = "recipe";
    public static final String UPDATE = "update";

    protected String type;
    protected String userId;
    protected String userName;
    protected String userPictureURL;

    public String getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPictureURL() {
        return userPictureURL;
    }
}

package com.gencat.kitchenite.model;

/**
 * Created by Tifani on 8/28/2016.
 */
abstract class Feed {
    public static final String RECIPE = "recipe";
    public static final String UPDATE = "update";

    protected String type;
    protected String userId;
    protected String userName;

    public String getType() {
        return type;
    }
}

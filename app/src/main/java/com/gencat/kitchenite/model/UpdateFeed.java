package com.gencat.kitchenite.model;

import java.io.Serializable;

/**
 * Created by Tifani on 8/28/2016.
 */
public class UpdateFeed extends Feed implements Serializable {
    public static final String MADE = "made";
    public static final String STAR = "star";
    public static final String FOLLOW = "follow";
    public static final String NEW_RECIPE = "new_recipe";


    private String updateType;
    private String recipeId;
    private String recipeName;
    private String userId; //TODO: for follow
    private String userName;
    private String content;

    public UpdateFeed(String updateType, String recipeId, String recipeName, String content) {
        this.updateType = updateType;
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.content = content;
    }
}

package com.gencat.kitchenite.model;

import java.io.Serializable;

/**
 * Created by Tifani on 8/28/2016.
 */
public class RecipeFeed extends Feed implements Serializable {
    private String recipeId;
    private String recipeName;
    private int difficulties;
    private int made;
    private int stars;
    private int comments;

    public RecipeFeed(String recipeId, String recipeName, int difficulties, int made, int stars, int comments, String userId, String userName) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.difficulties = difficulties;
        this.made = made;
        this.stars = stars;
        this.comments = comments;
        super.type = super.RECIPE;
        super.userId = userId;
        super.userName = userName;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getDifficulties() {
        return difficulties;
    }

    public int getMade() {
        return made;
    }

    public int getStars() {
        return stars;
    }

    public int getComments() {
        return comments;
    }

    public String getUserId() {
        return super.userId;
    }

    public String getUserName() {
        return super.userName;
    }
}

package com.gencat.kitchenite.model;

import java.io.Serializable;

/**
 * Created by Tifani on 8/28/2016.
 */
public class RecipeFeed extends Feed implements Serializable {
    private String recipeId;
    private String recipeName;
    private String recipePhotoURL;
    private char entree;
    private int made;
    private float stars;
    private int comments;
    private boolean bookmarked;

    public RecipeFeed(String recipeId, String recipeName, String recipePhotoURL, char entree, int made, float stars, int comments, boolean bookmarked, String userId, String userName, String userPictureURL) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipePhotoURL = recipePhotoURL;
        this.entree = entree;
        this.made = made;
        this.stars = stars;
        this.comments = comments;
        this.bookmarked = bookmarked;
        super.type = super.RECIPE;
        super.userId = userId;
        super.userName = userName;
        super.userPictureURL = userPictureURL;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipePhotoURL() {
        return recipePhotoURL;
    }

    public char getEntree() {
        return entree;
    }

    public int getMade() {
        return made;
    }

    public float getStars() {
        return stars;
    }

    public int getComments() {
        return comments;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }
}

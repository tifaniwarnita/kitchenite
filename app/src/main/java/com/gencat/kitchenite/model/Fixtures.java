package com.gencat.kitchenite.model;

import java.util.ArrayList;

/**
 * Created by Tifani on 8/30/2016.
 */
public class Fixtures {
    private static ArrayList<Feed> homeFeeds = new ArrayList<>();
    private static ArrayList<Feed> updateFeeds = new ArrayList<>();
    private static ArrayList<Feed> searchResult = new ArrayList<>();

    public static void initializeFixtures() {
        initializeHomeFeeds();
        initializeUpdateFeeds();
        initializeSearchResult();
    }

    private static void initializeHomeFeeds() {
        homeFeeds.add(new RecipeFeed("1",
                "Swedish Meatballs",
                "http://tastyfoodsnacks.com/wp-content/uploads/2013/12/Swedish-Meatballs-Holiday-Appetizer-Recipes.png",
                'A',
                22,
                4.5f,
                33,
                false,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));

        homeFeeds.add(new RecipeFeed("2",
                "Ayam Saus Pedas",
                "http://weneedfun.com/wp-content/uploads/2015/10/Beautiful-Food-Photos-8.jpg",
                'M',
                20,
                3.0f,
                5,
                true,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));

        homeFeeds.add(new RecipeFeed("2",
                "Pudding Stroberi",
                "https://images6.alphacoders.com/434/434430.jpg",
                'D',
                2,
                4.0f,
                34,
                false,
                "1",
                "William",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAUWAAAAJGUxODViNGRjLTNhNDctNDVlYy05NjJmLTQ4YTMxMGY2MDI3Mg.jpg"));
    }

    private static void initializeUpdateFeeds() {
        updateFeeds.add(new RecipeFeed("1",
                "Swedish Meatballs",
                "http://tastyfoodsnacks.com/wp-content/uploads/2013/12/Swedish-Meatballs-Holiday-Appetizer-Recipes.png",
                'A',
                22,
                4.5f,
                33,
                false,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));

        updateFeeds.add(new UpdateFeed(
                UpdateFeed.MADE,
                "1",
                "Bola Salju",
                " made it",
                "1",
                "William",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAUWAAAAJGUxODViNGRjLTNhNDctNDVlYy05NjJmLTQ4YTMxMGY2MDI3Mg.jpg"));


        updateFeeds.add(new RecipeFeed("2",
                "Pudding Stroberi",
                "https://images6.alphacoders.com/434/434430.jpg",
                'D',
                2,
                4.0f,
                34,
                false,
                "1",
                "William",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAUWAAAAJGUxODViNGRjLTNhNDctNDVlYy05NjJmLTQ4YTMxMGY2MDI3Mg.jpg"));

    }

    private static void initializeSearchResult() {
        searchResult.add(new RecipeFeed("2",
                "Ayam Saus Pedas",
                "http://weneedfun.com/wp-content/uploads/2015/10/Beautiful-Food-Photos-8.jpg",
                'M',
                20,
                3.0f,
                5,
                true,
                "1",
                "Tifani",
                "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAVmAAAAJGE4ZDYzOTFmLWU5NDQtNGMxYi1hNGJiLWM3MjQwYjI3N2EzOA.jpg"));
    }

    public static ArrayList<Feed> getHomeFeeds() {
        return homeFeeds;
    }

    public static ArrayList<Feed> getUpdateFeeds() {
        return updateFeeds;
    }

    public static ArrayList<Feed> getSearchResult() {
        return searchResult;
    }
}

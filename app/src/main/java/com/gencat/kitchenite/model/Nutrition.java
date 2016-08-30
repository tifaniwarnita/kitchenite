package com.gencat.kitchenite.model;

/**
 * Created by Tifani on 8/31/2016.
 */
public class Nutrition {
    private String name;
    private String count;

    public Nutrition(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }
}

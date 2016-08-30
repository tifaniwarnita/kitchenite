package com.gencat.kitchenite.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tifani on 8/31/2016.
 */
public class Ingredient implements Serializable {
    private ArrayList<String> content;

    public Ingredient(ArrayList<String> content) {
        this.content = content;
    }

    public String getCount() {
        return content.get(0);
    }

    public String getMaterial() {
        return content.get(1);
    }
}

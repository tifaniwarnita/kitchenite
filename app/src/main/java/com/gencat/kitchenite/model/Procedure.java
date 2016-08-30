package com.gencat.kitchenite.model;

import java.util.ArrayList;

/**
 * Created by Tifani on 8/31/2016.
 */
public class Procedure {
    private ArrayList<String> step; //0: step x, 1: content

    public Procedure(ArrayList<String> steps) {
        this.step = steps;
    }

    public ArrayList<String> getSteps() {
        return step;
    }

    public String getStepNumber() {
        return step.get(0);
    }

    public String getStepDetail() {
        return step.get(1);
    }
}

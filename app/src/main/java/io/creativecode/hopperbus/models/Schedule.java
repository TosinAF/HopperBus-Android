package io.creativecode.hopperbus.models;

import java.util.ArrayList;

public class Schedule {

    private ArrayList<Stop> mStops;

    public Schedule(ArrayList<Stop> stops) {

        this.mStops = stops;
    }

    public ArrayList<Stop> getStops() {
        return this.mStops;
    }
}

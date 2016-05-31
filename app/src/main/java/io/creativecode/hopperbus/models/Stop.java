package io.creativecode.hopperbus.models;

public class Stop {

    private String mID;
    private String mName;
    private String mTime;

    public Stop(String id, String name, String time) {

        this.mID = id;
        this.mName = name;
        this.mTime = time;
    }

    public String getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    public String getTime() {
        return mTime;
    }
}

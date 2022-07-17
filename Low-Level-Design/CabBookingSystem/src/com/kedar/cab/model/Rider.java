package com.kedar.cab.model;

public class Rider {

    private long riderId;
    private String riderName;

    public long getRiderId() {
        return riderId;
    }


    public String getRiderName() {
        return riderName;
    }

    public Rider(long riderId, String riderName) {
        this.riderId = riderId;
        this.riderName = riderName;
    }
}

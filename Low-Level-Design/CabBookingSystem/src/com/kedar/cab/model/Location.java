package com.kedar.cab.model;

public class Location {

    private Double latitude;
    private Double longitude;

    //calculate the distance

    public Double calculateDistance(Location location2) {
        return Math.sqrt(Math.pow(this.latitude - location2.latitude, 2) + Math.pow(this.longitude - location2.longitude, 2));
    }

}

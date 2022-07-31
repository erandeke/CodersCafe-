package com.kedar.cab.model;

public class Trip {

    private Rider rider;
    private long tripId;
    private Cab cab;
    private Double fare;
    private Location source;
    private Location destination;


    public Trip() {
        this.tripId = 0;
    }


    public Trip(Rider rider, Long tripId, Cab cab, Double fare, Location source, Location destination) {
        this.rider = rider;
        this.tripId = tripId;
        this.cab = cab;
        this.fare = fare;
        this.source = source;
        this.destination = destination;
    }

    public long getTripId() {
        return tripId;
    }
}

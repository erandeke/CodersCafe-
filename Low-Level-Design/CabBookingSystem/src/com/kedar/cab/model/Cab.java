package com.kedar.cab.model;

public class Cab {

    private long cabId;
    private Trip currentTrip;
    private Driver driver;
    Location currentLocation;
    Boolean isCabAvailable;

    public long getCabId() {
        return cabId;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Boolean isCabAvailable() {
        return isCabAvailable;
    }


    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public void setCurrentTrip(Trip trip) {
        this.currentTrip = trip;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCabAvailable(Boolean cabAvailable) {
        isCabAvailable = cabAvailable;
    }
}

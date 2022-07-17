package com.kedar.cab.controller;

import com.kedar.cab.model.Location;
import com.kedar.cab.model.Rider;
import com.kedar.cab.model.Trip;
import com.kedar.cab.repo.RiderManager;
import com.kedar.cab.repo.TripManager;

public class RiderController {

    private RiderManager riderManager;
    private TripManager tripManager;

    public RiderController(RiderManager riderManager, TripManager tripManager) {
        this.riderManager = riderManager;
        this.tripManager = tripManager;
    }

    public RiderController() {
        this.riderManager = new RiderManager();
    }

    public void registerRider(Rider rider) {
        this.riderManager.storeInRiderRegister(rider);
    }


    public Trip bookTrip(Location src, Location dest, Rider rider) {
        return this.tripManager.createTripForRider(src, dest, rider);
    }

    public void cancelTrip(Rider rider, Long tripId) {
        tripManager.cancelTripForRider(rider, tripId);
    }
}

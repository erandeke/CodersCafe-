package com.kedar.cab.controller;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;
import com.kedar.cab.repo.CabManager;

public class CabController {

    CabManager cabManager;

    public CabController() {
        this.cabManager = new CabManager();
    }


    public Cab registerCab(Cab cab) {
        return cabManager.registerCabs(cab);
    }

    private void updateLocationOfTheCab(Location locationForTheCab, Cab cab) {
        cabManager.setCurrentLocationForTheCab(locationForTheCab, cab);
    }


    private void updateCabAvailability(Cab cab, Boolean availability) {
        cabManager.updateCabAvailability(cab, availability);
    }
}

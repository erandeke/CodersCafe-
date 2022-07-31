package com.kedar.cab.strategy;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;
import com.kedar.cab.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

    @Override
    public Cab matchCabsToRider(Rider rider, List<Cab> cabList, Location from, Location to) {
        if (!cabList.isEmpty()) return cabList.get(0);
        return null; //No cab
    }
}

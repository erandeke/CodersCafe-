package com.kedar.cab.strategy;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;
import com.kedar.cab.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {

    Cab matchCabsToRider(Rider rider , List<Cab> cabList, Location from, Location to);
}

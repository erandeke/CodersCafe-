package com.kedar.cab.strategy;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;
import com.kedar.cab.model.Rider;

import java.util.List;

public class Context {

    private CabMatchingStrategy cabMatchingStrategy;
    private FareCalculationStrategy fareCalculationStrategy;

    public Context() {

    }

    public Context(CabMatchingStrategy cabMatchingStrategy) {
        this.cabMatchingStrategy = cabMatchingStrategy;
    }

    public Context(FareCalculationStrategy fareCalculationStrategy) {
        this.fareCalculationStrategy = fareCalculationStrategy;
    }


    public Cab matchCabToRider(Rider rider, List<Cab> cabList, Location from, Location to) {
        return cabMatchingStrategy.matchCabsToRider(rider, cabList, from, to);
    }


    public Double calculateFare(Location from, Location destination) {
        return fareCalculationStrategy.calculateFare(from, destination);
    }
}

package com.kedar.cab.strategy;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;

public class DefaultFareCalculationStrategy implements FareCalculationStrategy {

    private static final Double fareForTenKM = 100.0;

    @Override
    public Double calculateFare(Location src, Location dest) {
        return (src.calculateDistance(dest)) * fareForTenKM;
    }
}

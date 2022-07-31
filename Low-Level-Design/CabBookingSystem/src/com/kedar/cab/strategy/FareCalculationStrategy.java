package com.kedar.cab.strategy;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;

public interface FareCalculationStrategy {

    Double calculateFare(Location src, Location dest);
}

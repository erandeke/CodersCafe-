package com.kedar.parkinglot.strategies;

import com.kedar.parkinglot.models.ParkingSpotType;
import com.kedar.parkinglot.models.VehicleType;

public class ParkingSpotVehicleMatchingTypeStrategy {

    public boolean isMatch(VehicleType vehicleType, ParkingSpotType parkingSpotType) {
        return switch (parkingSpotType) {
            case LARGE -> vehicleType.equals(VehicleType.LARGE);
            case SMALL -> vehicleType.equals(VehicleType.SMALL);
            case COMPACT -> vehicleType.equals(VehicleType.COMPACT);
            case MEDIUM -> vehicleType.equals(VehicleType.MEDIUM);

        };
    }
}

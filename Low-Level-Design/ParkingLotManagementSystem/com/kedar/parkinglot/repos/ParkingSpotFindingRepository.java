package com.kedar.parkinglot.repos;

import com.kedar.parkinglot.models.ParkingFloors;
import com.kedar.parkinglot.models.ParkingLot;
import com.kedar.parkinglot.models.ParkingSpot;
import com.kedar.parkinglot.models.Vehicle;

import java.util.List;

public interface ParkingSpotFindingRepository {

     ParkingSpot findAvailableParkingSpot(Vehicle vehicle, ParkingLot parkingLot);

     void saveParkingLot(long id, ParkingLot parkingLot);

    void saveParkingFloors(ParkingLot parkingLot, List<ParkingFloors> parkingFloorsList);

    void saveParkingSpotsForEachFloor(ParkingFloors parkingFloors , List<ParkingSpot> parkingSpotList);

    Integer availableSlots(ParkingLot parkingLot);
}

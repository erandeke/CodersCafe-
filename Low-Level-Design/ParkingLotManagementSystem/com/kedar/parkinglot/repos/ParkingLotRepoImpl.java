package com.kedar.parkinglot.repos;

import com.kedar.parkinglot.exceptions.NoParkingSpotFoundException;
import com.kedar.parkinglot.models.*;
import com.kedar.parkinglot.strategies.ParkingSpotVehicleMatchingTypeStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepoImpl implements ParkingSpotFindingRepository {

    private ParkingSpotVehicleMatchingTypeStrategy parkingSpotVehicleMatchingTypeStrategy;
    Map<Long, ParkingLot> parkingLotDataStore = new HashMap<>();

    Map<ParkingLot, List<ParkingFloors>> parkingFloorMap = new HashMap<>();

    Map<ParkingFloors, List<ParkingSpot>> parkingSpotDataStore = new HashMap<>();


    public ParkingLotRepoImpl(ParkingSpotVehicleMatchingTypeStrategy parkingSpotVehicleMatchingTypeStrategy) {
        this.parkingSpotVehicleMatchingTypeStrategy = parkingSpotVehicleMatchingTypeStrategy;
    }


    @Override
    public ParkingSpot findAvailableParkingSpot(Vehicle vehicle, ParkingLot parkingLot) throws NoParkingSpotFoundException {
        for (ParkingFloors parkingFloors : parkingFloorMap.get(parkingLot)) {
            for (ParkingSpot parkingSpot : parkingSpotDataStore.get(parkingFloors)) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpotVehicleMatchingTypeStrategy.isMatch(vehicle.getVehicleType(), parkingSpot.getParkingSpotType()))
                    bookSpot(parkingLot);
                    return parkingSpot;
            }
        }
        throw new NoParkingSpotFoundException(String.join("No parkingSpot available at this time for", "  ", parkingLot.getParkingLotName()));
    }

    @Override
    public void saveParkingLot(long id, ParkingLot parkingLot) {
        parkingLotDataStore.put(id, parkingLot);
    }

    @Override
    public void saveParkingFloors(ParkingLot parkingLot, List<ParkingFloors> parkingFloorsList) {
        parkingFloorMap.putIfAbsent(parkingLot, parkingFloorsList);
    }

    @Override
    public void saveParkingSpotsForEachFloor(ParkingFloors parkingFloors, List<ParkingSpot> parkingSpotList) {
        parkingSpotDataStore.put(parkingFloors, parkingSpotList);
    }

    @Override
    public Integer availableSlots(ParkingLot parkingLot) {
       return parkingLot.getCapacity().getCapacity();
    }

    public void bookSpot(ParkingLot parkingLot) {
        int reduced = parkingLot.getCapacity().getCapacity();
        parkingLot.setCapacity(new Capacity(reduced--));
    }
}

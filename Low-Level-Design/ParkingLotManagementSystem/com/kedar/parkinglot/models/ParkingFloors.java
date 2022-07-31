package com.kedar.parkinglot.models;

import java.util.List;
import java.util.Objects;

public class ParkingFloors extends BaseModel {

    List<ParkingSpot> parkingSpotList;
    int floorNumber;


    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingFloors that = (ParkingFloors) o;
        return floorNumber == that.floorNumber && Objects.equals(parkingSpotList, that.parkingSpotList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpotList, floorNumber);
    }
}

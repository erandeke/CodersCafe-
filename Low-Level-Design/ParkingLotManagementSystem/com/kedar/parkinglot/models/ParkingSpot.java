package com.kedar.parkinglot.models;

import java.util.Objects;

public class ParkingSpot extends BaseModel {

    private ParkingSpotType parkingSpotType;
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return spotNumber == that.spotNumber && parkingSpotType == that.parkingSpotType && parkingSpotStatus == that.parkingSpotStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpotType, spotNumber, parkingSpotStatus);
    }
}

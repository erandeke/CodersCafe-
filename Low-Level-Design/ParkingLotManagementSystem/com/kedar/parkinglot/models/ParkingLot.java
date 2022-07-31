package com.kedar.parkinglot.models;

import java.util.List;
import java.util.Objects;

public class ParkingLot extends BaseModel {

    private List<ParkingFloors> parkingFloorsList;
    private List<Gate> gates;
    private String zipCode;

    private String parkingLotName;

    private Capacity capacity;


    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public ParkingLot(List<ParkingFloors> parkingFloorsList) {
        this.parkingFloorsList = parkingFloorsList;
    }

    public List<ParkingFloors> getParkingFloorsList() {
        return parkingFloorsList;
    }

    public void setParkingFloorsList(List<ParkingFloors> parkingFloorsList) {
        this.parkingFloorsList = parkingFloorsList;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(List<ParkingFloors> parkingFloorsList, List<Gate> gates, String zipCode, String parkingLotName, Capacity capacity) {
        this.parkingFloorsList = parkingFloorsList;
        this.gates = gates;
        this.zipCode = zipCode;
        this.parkingLotName = parkingLotName;
        this.capacity = capacity;
    }

    public ParkingLot() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(parkingFloorsList, that.parkingFloorsList) && Objects.equals(gates, that.gates) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingFloorsList, gates, zipCode);
    }
}

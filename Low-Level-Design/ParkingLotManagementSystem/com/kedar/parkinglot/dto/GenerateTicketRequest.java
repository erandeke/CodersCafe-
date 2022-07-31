package com.kedar.parkinglot.dto;

import com.kedar.parkinglot.models.EntryGate;
import com.kedar.parkinglot.models.ParkingLot;
import com.kedar.parkinglot.models.Vehicle;
import com.kedar.parkinglot.models.VehicleType;

import java.time.LocalTime;

public class GenerateTicketRequest {

    private String vehicleNumber;
    private LocalTime entryTime;
    private EntryGate entryGate;

    private Vehicle vehicle;
    private ParkingLot parkingLot;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicleType(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

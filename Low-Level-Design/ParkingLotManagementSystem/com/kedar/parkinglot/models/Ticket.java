package com.kedar.parkinglot.models;

import java.time.LocalTime;

public class Ticket extends BaseModel {

    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalTime localEntryTime;
    private EntryGate entryGate;
    private int ticketNumber;


    public Ticket()
    {

    }

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot, LocalTime localEntryTime, EntryGate entryGate, int ticketNumber) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.localEntryTime = localEntryTime;
        this.entryGate = entryGate;
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalTime getLocalEntryTime() {
        return localEntryTime;
    }

    public void setLocalEntryTime(LocalTime localEntryTime) {
        this.localEntryTime = localEntryTime;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}

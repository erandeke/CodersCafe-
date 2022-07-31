package com.kedar.parkinglot.dto;

import com.kedar.parkinglot.models.ParkingSpot;

import java.time.LocalTime;

public class TicketDto {

    private int ticketNumber;
    private LocalTime startTime;
    private int floorNumber;
    private int spotNumber;

    public TicketDto(int ticketNumber, LocalTime startTime, int floorNumber, int spotNumber) {
        this.ticketNumber = ticketNumber;
        this.startTime = startTime;
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}

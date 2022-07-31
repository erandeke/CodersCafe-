package com.kedar.parkinglot.service;

import com.kedar.parkinglot.dto.GenerateTicketRequest;
import com.kedar.parkinglot.models.ParkingLot;
import com.kedar.parkinglot.models.ParkingSpot;
import com.kedar.parkinglot.models.Ticket;
import com.kedar.parkinglot.repos.ParkingSpotFindingRepository;

public class TickerGenerationService {

    private ParkingSpotFindingRepository parkingSpotFindingRepository;

    private int counter = 0;

    public TickerGenerationService(ParkingSpotFindingRepository parkingSpotFindingRepository) {
        this.parkingSpotFindingRepository = parkingSpotFindingRepository;
        this.counter = 1;

    }

    protected boolean isParkingLotFull(ParkingLot parkingLot) {
        Integer totalCapacity = parkingSpotFindingRepository.availableSlots(parkingLot);
        if (totalCapacity >= parkingLot.getCapacity().getCapacity()) return true;

        return false;
    }

    public Ticket getTicketForTheParkingLot(GenerateTicketRequest request) {
        if(!isParkingLotFull(request.getParkingLot())) {
            ParkingSpot parkingSpot = parkingSpotFindingRepository.findAvailableParkingSpot(request.getVehicle(), request.getParkingLot());
            Ticket ticket = new Ticket();
            ticket.setTicketNumber(counter++);
            ticket.setParkingSpot(parkingSpot);
            ticket.setEntryGate(request.getEntryGate());
            ticket.setLocalEntryTime(request.getEntryTime());
        }

        return null;
    }
}

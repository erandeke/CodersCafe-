package com.kedar.flight.reservation.fly;

import com.kedar.flight.reservation.user.Travellers;

import java.util.List;

public class SpecialSeats extends Seat {

    int specialSeatId;

    @Override
    double calculateFare(Flight flight, List<Travellers> travellers) {
        //do some extra calculation to add fare of special seats
        return 11.11;
    }
}

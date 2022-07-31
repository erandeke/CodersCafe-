package com.kedar.flight.reservation.fly;

import com.kedar.flight.reservation.user.Member;
import com.kedar.flight.reservation.user.Travellers;

import java.util.List;

public class Seat {

    private int seatId;
    double fare;
    Flight flight;
    Member member;


    void addTravellers() {
        //list of travellers
    }

    double calculateFare(Flight flight, List<Travellers> travellersList) {
        return 11.11;
    }
}

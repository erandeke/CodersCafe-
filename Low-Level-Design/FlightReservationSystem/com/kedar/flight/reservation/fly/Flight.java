package com.kedar.flight.reservation.fly;

import java.util.List;

public class Flight {

    private String flightId;
    private String flightName;
    List<Seat> seatList; // 1 to many relation ship with flight -> seats
    Fare fare; // 1 flight will have 1 fare
    //There will be fare calculation service that would update the fares for each date
    Fare calculateFareForThatDay() {
        //get the fare for the flight
        return new Fare();
    }


}

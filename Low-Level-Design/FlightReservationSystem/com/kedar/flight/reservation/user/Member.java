package com.kedar.flight.reservation.user;

import com.kedar.flight.reservation.fly.Flight;
import com.kedar.flight.reservation.fly.FlightSchedule;
import com.kedar.flight.reservation.fly.Trip;

public class Member {

    Account account;

    private void login() {

    }

    FlightSchedule searchFlights(Trip trip) {
        return new FlightSchedule();
    }

    Flight bookFlightTickets(Flight flight)
    {
        return new Flight();
    }

    void makePayment()
    {
        //use some payment strategies
        //or intergrate with third party api
    }
}

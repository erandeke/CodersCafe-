package com.kedar.flight.reservation.fly;

import java.util.Date;
import java.util.List;

public class FlightSchedule {

    int flightScheduleId;
    Trip trip;
    List<Flight> flightList;

    //the below api will fetch the list of flights from the request body using
    //trip id , departure and arrival
    List<Flight> getListOfFlights(Date departure, Date arrival, String tripId) {
        return flightList;
    }

}

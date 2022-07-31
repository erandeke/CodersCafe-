package com.kedar.flight.reservation.fly;

import java.util.Date;

public class Trip {

    private String tripId; //this I am thinking as a composite key formed by src and destination
    Airport source;
    Airport destination;
    TravellerClass travellerClass;
    Date departure;
    Date arrival;

}

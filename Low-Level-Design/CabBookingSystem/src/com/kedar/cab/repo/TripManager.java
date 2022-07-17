package com.kedar.cab.repo;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;
import com.kedar.cab.model.Rider;
import com.kedar.cab.model.Trip;
import com.kedar.cab.strategy.CabMatchingStrategy;
import com.kedar.cab.strategy.FareCalculationStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class TripManager {

    private static final Double MAX_DISTANCE_RADIUS = 10.0;
    Map<Rider, List<Trip>> history = new HashMap<>();

    Map<Rider, Trip> currentTrip = new HashMap<>();
    private CabManager cabManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private FareCalculationStrategy fareCalculationStrategy;

    Long tripId = 0L;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public TripManager(CabMatchingStrategy cabMatchingStrategy, FareCalculationStrategy fareCalculationStrategy) {
        this.cabManager = new CabManager();
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
        setTripId(0l);

    }


    public Trip createTripForRider(Location src, Location dest, Rider rider) {
        //get the cabs that are closerBy
        List<Cab> closerByCabs = this.cabManager.getTheCabCloserBy(src, MAX_DISTANCE_RADIUS);
        List<Cab> availableCabs = closerByCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());
        //cab and rider matching strategy
        Cab cab = cabMatchingStrategy.matchCabsToRider(rider, availableCabs, src, dest);
        if (cab == null) {
            //throw cabNotfoundexception //print erro message
        }

        Double fare = fareCalculationStrategy.calculateFare(src, dest);
        Long tripId = getTripId();
        setTripId(tripId++);
        Trip trip = new Trip(rider, getTripId(), cab, fare, src, dest);
        currentTrip.put(rider, trip);
        cab.setCurrentTrip(trip);
        cab.setCabAvailable(false);
        //maintain the  history of rider trips :
        if (!history.containsKey(rider)) {
            history.put(rider, new ArrayList<>());
        }
        history.get(rider).add(trip);
        return trip;
    }


    public void cancelTripForRider(Rider rider, Long tripId) {
        if (!history.containsKey(rider)) {
            //throw exception : No trip found for cancellation
        }
        List<Trip> list = history.get(rider);
        if (!list.isEmpty()) {
            Optional<Trip> trip = list.stream().filter(tr -> tr.getTripId() == tripId).findFirst();
            if (trip.isPresent()) {
                list.remove(trip);
            }
        } else {
            //no active trips found for the rider;
        }
    }
}

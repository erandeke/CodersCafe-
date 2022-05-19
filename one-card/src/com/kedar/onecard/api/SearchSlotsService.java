package com.kedar.onecard.api;

import com.kedar.onecard.model.Booking;
import com.kedar.onecard.model.Intervals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 */
public class SearchSlotsService {


    public SearchSlotsService() {

    }

    public List<Intervals> fetchAvailableSlots(Booking booking, List<Intervals> timeSlots) {
        //Get the select time slots from bookingtableget the list from database
        //find the delta between two list total and booked
        int startTime = booking.getStartTime();
        int endTime = booking.getEndTime();
        Intervals intervals = new Intervals(startTime, endTime);
        List<Intervals> dbTimeSlots = new ArrayList<>(Arrays.asList(intervals));
        //find the difference between the time-slots to get the available bookings
        timeSlots.removeAll(dbTimeSlots);
        return timeSlots;
    }


}

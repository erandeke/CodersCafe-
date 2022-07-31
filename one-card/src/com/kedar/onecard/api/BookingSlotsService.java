package com.kedar.onecard.api;

import com.kedar.onecard.model.Booking;
import com.kedar.onecard.model.Intervals;

import java.awt.print.Book;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class BookingSlotsService {

    private Intervals intervals;

    public BookingSlotsService() {
        intervals = new Intervals();
    }

    public void bookSlot(Booking booking) {
        List<Intervals> list = intervals.getIntervals();
        int startTime = booking.getStartTime();
        int endTime = booking.getEndTime();
        //insert into database for the booking id and start tine and endtime
    }
}

package com.kedar.onecard.model;

import java.util.Date;

/**
 * @author Kedar Erande
 */
public class Booking {
    long bookingId;
    int startTime;
    int endTime;
    Date bookingDate;

    public Booking(long bookingId, int startTime, int endTime, Date date) {
        this.bookingDate = date;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}

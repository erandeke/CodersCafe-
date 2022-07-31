package com.kedar.onecard.model;

/**
 * @author Kedar Erande
 */
public class Customer {
    int cust_id;
    String name;
    String emailId;
    Booking booking; //this should not be customer centric
    //as we just need to maintain the booked slots and available time slots

    public Customer(int cust_id, String name, String emailId, Booking booking) {
        this.cust_id = cust_id;
        this.name = name;
        this.emailId = emailId;
        this.booking = booking;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

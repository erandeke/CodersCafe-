package com.kedar.onecard.api;

import com.kedar.onecard.model.Customer;
import com.kedar.onecard.model.Intervals;

import java.util.List;

/**
 * @author Kedar Erande
 */
public class Controller {

    private SearchSlotsService searchSlotsService;
    private BookingSlotsService bookingSlotsService;

    public Controller() {
        this.searchSlotsService = new SearchSlotsService();
        this.bookingSlotsService = new BookingSlotsService();
    }


    public void bookSlot(Customer customer) {
        bookingSlotsService.bookSlot(customer.getBooking());
    }

    public List<Intervals> getTheListOfAvailableSlots(Customer customer, List<Intervals> totalIntervals) {
        return searchSlotsService.fetchAvailableSlots(customer.getBooking(),totalIntervals);
    }

}

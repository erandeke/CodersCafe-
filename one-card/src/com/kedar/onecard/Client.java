package com.kedar.onecard;

import com.kedar.onecard.api.Controller;
import com.kedar.onecard.model.Booking;
import com.kedar.onecard.model.Customer;
import com.kedar.onecard.model.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 */
public class Client {
    public static void main(String[] args) {
        Intervals intervals = new Intervals();
        intervals.populateIntervalsInventory();
        intervals.printIntervals();
        List<Intervals> list = intervals .getIntervals();
        Booking booking = new Booking(1000, 8, 9, new Date(2022, 8, 9));
        Customer customer = new Customer(1, "Kedar", "erande.kedar@gmail.com", booking);
        Controller controller = new Controller();
        List<Intervals> availableTimeSlots = controller.getTheListOfAvailableSlots(customer,list);
        for (Intervals timeslots : availableTimeSlots) {
            System.out.println("start time" + timeslots.getStartTime());
            System.out.println("end time" + timeslots.getEndTime());

        }

        List<Integer> list1 =  new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
        List<Integer> differences = list1.stream().filter(ele->!list2.contains(ele)).collect(Collectors.toList());
        System.out.println(differences);


    }
}

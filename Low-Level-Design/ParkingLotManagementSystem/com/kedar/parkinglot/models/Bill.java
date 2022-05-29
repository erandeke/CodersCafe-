package com.kedar.parkinglot.models;

import java.time.LocalTime;

public class Bill {

    private Ticket ticket;
    private String billNo;
    private LocalTime endTime;
    private ExitGate exitGate;
    private Payment payment;
    private BillStatus billStatus;



}

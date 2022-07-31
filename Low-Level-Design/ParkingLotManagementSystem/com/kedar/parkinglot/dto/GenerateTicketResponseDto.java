package com.kedar.parkinglot.dto;

import com.kedar.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {

    Ticket ticket;

    public GenerateTicketResponseDto(Ticket ticket) {
        this.ticket = ticket;
    }
}

package com.kedar.parkinglot.controllers;

import com.kedar.parkinglot.dto.GenerateTicketRequest;
import com.kedar.parkinglot.dto.GenerateTicketResponseDto;
import com.kedar.parkinglot.dto.TicketDto;
import com.kedar.parkinglot.models.Ticket;
import com.kedar.parkinglot.service.TickerGenerationService;

import java.time.LocalTime;

public class TicketController {

    TickerGenerationService tickerGenerationService;

    public TicketController(TickerGenerationService tickerGenerationService) {
        this.tickerGenerationService = tickerGenerationService;
    }

    GenerateTicketResponseDto generateTicket(GenerateTicketRequest request) {

        Ticket ticket = tickerGenerationService.getTicketForTheParkingLot(request);
        return new GenerateTicketResponseDto(ticket);
    }
}

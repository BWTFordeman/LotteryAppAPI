package com.example.LotteryAppAPI.api.controller;

import com.example.LotteryAppAPI.repository.TicketRepository;
import com.example.LotteryAppAPI.api.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TicketController {
    private static final Logger logger = LogManager.getLogger(Ticket.class);

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public Iterable<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @PostMapping("/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}

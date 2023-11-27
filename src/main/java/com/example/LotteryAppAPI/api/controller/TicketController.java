package com.example.LotteryAppAPI.api.controller;

import com.example.LotteryAppAPI.repository.TicketRepository;
import com.example.LotteryAppAPI.api.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://zealous-forest-0040a6803.4.azurestaticapps.net/")
@RestController
@RequestMapping("/")
public class TicketController {
    private static final Logger logger = LogManager.getLogger(Ticket.class);

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public Iterable<Ticket> getTickets(@RequestParam(name = "ticketDate", required = false) String ticketDate, @RequestParam(name = "buyerName", required = false) String buyerName) {
        if (ticketDate != null && !ticketDate.isEmpty()) {
            // Filter tickets by buyerName
            return ticketRepository.findByTicketDate(ticketDate);
        } else {
            if (buyerName != null && !buyerName.isEmpty()) {
                return ticketRepository.findByBuyerName(buyerName);
            }
            // Return all tickets if no buyerName parameter is provided
            return ticketRepository.findAll();
        }
    }

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Ticket> createTickets(@RequestBody Iterable<Ticket> tickets) {
        return ticketRepository.saveAll(tickets);
    }

    @PostMapping("/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}

package com.example.LotteryAppAPI.repository;

import com.example.LotteryAppAPI.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Iterable<Ticket> findByTicketDate(String ticketDate);

    Iterable<Ticket> findByBuyerName(String buyerName);
}

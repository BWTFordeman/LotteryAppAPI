package com.example.LotteryAppAPI.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    public Ticket() {

    }

    public Ticket(int id, String buyerName, String ticketDate, Integer ticketNumber) {
        this.id = id;
        this.buyerName = buyerName;
        this.ticketDate = ticketDate;
        this.ticketNumber = ticketNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "ticket_date")
    private String ticketDate;
    @Column(name = "ticket_number")
    private Integer ticketNumber;

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.cinema.tickets.web.bean;

/**
* Created by Jordan Danchev on 15.1.2015 г..
*/


import com.cinema.tickets.enums.Ticket;
import com.cinema.tickets.service.impl.TicketServiceImpl;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;




@ManagedBean(name = "dtTicketFilterView")
@ViewScoped
public class TicketFilterView implements Serializable {



    private List<Ticket> tickets;
    private List<Ticket> filteredTickets;

    @ManagedProperty("#{ticketService}")
    private TicketServiceImpl service;

    @PostConstruct
    public void init() {
        tickets = service.createTickets(50);
    }


    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setService(TicketServiceImpl service) {
        this.service = service;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getFilteredTickets() {
        return filteredTickets;
    }

    public void setFilteredTickets(List<Ticket> filteredTickets) {
        this.filteredTickets = filteredTickets;
    }







}

package com.cinema.tickets.web.bean;

/**
* Created by Jordan Danchev on 15.1.2015 г..
*/

import com.cinema.tickets.enums.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "ticketService")
@ApplicationScoped
public class TicketService {

    private final static String[] users;

    static {
        users = new String[10];
        users[0] = "Ana";
        users[1] = "Ivan";
        users[2] = "Peter";
        users[3] = "Ana";
        users[4] = "Maria";
        users[5] = "Peter";
        users[6] = "Georgi";
        users[7] = "John";
        users[8] = "Jon";
        users[9] = "Tom";

    }

    public List<Ticket> createTickets(int size) {
        List<Ticket> list = new ArrayList<Ticket>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Ticket(getRandomId(), getRandomUser(), false));
        }

        return list;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }



    private String getRandomUser() {
        return users[(int) (Math.random() * 10)];
    }


//    public List<String> getUsers() {
//        return Arrays.asList(users);
//    }



}
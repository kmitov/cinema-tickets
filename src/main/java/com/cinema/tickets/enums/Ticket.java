package com.cinema.tickets.enums;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Jordan Danchev on 15.1.2015 г..
 */
public class Ticket {
    String id;
    String user;
    boolean taken;

    public Ticket(String id, String user, boolean bool)
    {
        this.id = id;
        this.user = user;
        this.taken = bool;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public boolean isTaken() {
        return taken;
    }

    public void addMessage() {
        String summary = taken ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}



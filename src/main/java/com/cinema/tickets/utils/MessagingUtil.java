package com.cinema.tickets.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by kmitov on 1/19/15.
 */
public class MessagingUtil {

    public static void addMessage(String message, String summary) {;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary, message));
    }
}

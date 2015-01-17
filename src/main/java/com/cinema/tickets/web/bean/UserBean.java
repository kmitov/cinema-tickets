package com.cinema.tickets.web.bean;

import com.cinema.tickets.service.UserService;
import com.sun.java.util.jar.pack.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class UserBean {

    UserService userService;

    String username;
    String password;
    String firstName;
    String lastName;
//    String debug;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void createAccount(){
        userService.createUserAccount(getUsername(),getPassword(), getFirstName(), getLastName());
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(getFirstName());
        writer.println(getUsername());
        writer.close();
//        debug = getUsername() + " " + getPassword();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

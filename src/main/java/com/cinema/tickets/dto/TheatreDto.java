package com.cinema.tickets.dto;

/**
 * Created by kmitov on 1/16/15.
 */
public class TheatreDto {
    private Long id;
    private int capacity;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

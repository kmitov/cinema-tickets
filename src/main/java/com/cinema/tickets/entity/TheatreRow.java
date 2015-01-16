package com.cinema.tickets.entity;

import javax.persistence.*;

/**
 * Created by kmitov on 1/15/15.
 */
@Entity
@Table(name = "theatreRows")
public class TheatreRow {

    private Long id;

    private int number;

    private Long theatreId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "theatreId", nullable = false)
    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}

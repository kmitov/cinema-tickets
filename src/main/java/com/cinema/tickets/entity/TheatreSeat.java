package com.cinema.tickets.entity;

import javax.persistence.*;

/**
 * Created by kmitov on 1/15/15.
 */
@Entity
@Table(name = "theatreSeats")
public class TheatreSeat {

    private Long id;

    private int number;

    private Long rowId;

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

    @Column(name = "rowId", nullable = false)
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }
}

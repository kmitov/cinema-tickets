package com.cinema.tickets.entity;

import javax.persistence.*;

/**
 * Created by Jordan Danchev on 15.1.2015 г..
 */

@Entity
@Table(name="tickets")
public class Ticket {
    private Long id;
    private Long reservationId;
    private Long projectionId;
    private Long rowId;
    private Long seatId;
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

    @Column(name = "reservationId", nullable = false)
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @Column(name = "projectionId", nullable = false)
    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    @Column(name = "rowId", nullable = false)
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    @Column(name = "seatId", nullable = false)
    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    @Column(name = "theatreId", nullable = false)
    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}



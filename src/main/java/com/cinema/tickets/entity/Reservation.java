package com.cinema.tickets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kmitov on 1/16/15.
 */
@Entity
@Table(name= "reservations")
public class Reservation {
    private Long id;
    private Long projectionId;
    private Long theatreId;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "projectionId", nullable = false)
    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    @Column(name = "theatreId", nullable = false)
    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

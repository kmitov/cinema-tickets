package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.ReservationAssembler;
import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.entity.Reservation;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ReservationAssemblerImpl implements ReservationAssembler {
    @Override
    public Reservation toEntity(ReservationDto reservationDto) {
        final Reservation entity = new Reservation();
        entity.setId(reservationDto.getId());
        entity.setTheatreId(reservationDto.getTheatreId());
        entity.setDate(reservationDto.getDate());
        entity.setProjectionId(reservationDto.getProjectionId());
        entity.setUserId(reservationDto.getUserId());
        return entity;
    }



    @Override
    public ReservationDto toDto(Reservation reservation) {
        final ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setTheatreId(reservation.getTheatreId());
        dto.setDate(reservation.getDate());
        dto.setProjectionId(reservation.getProjectionId());
        dto.setUserId(reservation.getUserId());
        return dto;
    }

    @Override
    public List<ReservationDto> toDtoList(List<Reservation> entities) {
        for(Reservation reservation : entities) {

        }
        return null;
    }
}

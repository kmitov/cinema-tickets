package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.entity.Reservation;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ReservationAssembler {
    Reservation toEntity(ReservationDto reservationDto);

    ReservationDto toDto(Reservation reservationDto);

    List<ReservationDto> toDtoList(List<Reservation> entities);

}

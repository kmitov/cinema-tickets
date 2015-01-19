package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Ticket;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface TicketAssembler {
    Ticket toEntity(TicketDto ticketDto);

    TicketDto toDto(Ticket ticket);

    List<TicketDto> toDtoList(List<Ticket> tickets);

}

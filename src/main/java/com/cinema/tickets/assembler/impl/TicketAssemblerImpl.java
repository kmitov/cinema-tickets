package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.TicketAssembler;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class TicketAssemblerImpl implements TicketAssembler {


    @Override
    public Ticket toEntity(TicketDto ticketDto) {
        final Ticket entity = new Ticket();
        entity.setId(ticketDto.getId());
        entity.setReservationId(ticketDto.getReservationId());
        entity.setProjectionId(ticketDto.getProjectionId());
        entity.setTheatreId(ticketDto.getTheatreId());
        entity.setRowId(ticketDto.getRowId());
        entity.setSeatId(ticketDto.getSeatId());
        return entity;
    }

    @Override
    public TicketDto toDto(Ticket ticket) {
        final TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setReservationId(ticket.getReservationId());
        dto.setProjectionId(ticket.getProjectionId());
        dto.setTheatreId(ticket.getTheatreId());
        dto.setRowId(ticket.getRowId());
        dto.setSeatId(ticket.getSeatId());
        return dto;

    }

    @Override
    public List<TicketDto> toDtoList(List<Ticket> tickets) {
        final List<TicketDto> result = new ArrayList<TicketDto>();
        for(Ticket ticket : tickets) {
            result.add(toDto(ticket));
        }
        return result;
    }
}

package com.portfolio.portfolio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {
    
    @Autowired
    private TicketsRepository ticketsRepository;

    public void saveTicket(Tickets ticket) {
        if (ticket.getTicket_id() == null) {
            ticket.setTicket_id(UUID.randomUUID().getMostSignificantBits());
        }
        ticketsRepository.saveTicket(ticket);
    }

    public Tickets getTicket(Long id) {
        return ticketsRepository.getTicketById(id);
    }

    public void deleteTicket(Long id) {
        ticketsRepository.deleteTicketById(id);
    }

    public void updateTicket(Tickets ticket) {
        ticketsRepository.updateTicket(ticket);
    }

    public Iterable<Tickets> getAllTickets() {
        return ticketsRepository.getAllTickets();
    }
}

package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TicketRepository;
import com.littlepage.airplaneticketsystem.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ticket service impl
 */
@Service
public class TicketServiceImpl implements TicketService {
    /**
     * ticket repository
     */
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * add ticket method
     * @param ticket
     */
    @Override
    public void buyTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    @Override
    public Integer getTicketNum(String afid) {
        return ticketRepository.getTicketNum(afid);
    }
}

package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.pojo.Ticket;

/**
 * ticket service
 */
public interface TicketService {
    /**
     * buy ticket method
     * @param ticket
     */
    void buyTicket(Ticket ticket);

    /**
     * get ticket num
     * @param afid
     */
    Integer getTicketNum(String afid);
}

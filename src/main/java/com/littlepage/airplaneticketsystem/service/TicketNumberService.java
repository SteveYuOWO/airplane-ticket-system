package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.vojo.TicketDetails;

/**
 * ticket number service
 */
public interface TicketNumberService {

    /**
     * set ticket number
     * @param ticketDetails
     */
    void setTicketNumber(TicketDetails ticketDetails);
}

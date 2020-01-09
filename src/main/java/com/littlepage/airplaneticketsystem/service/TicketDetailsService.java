package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.vojo.TicketDetails;

/**
 * Ticket details Service
 */
public interface TicketDetailsService {
    /**
     * get ticket details
     * @param afid
     * @return
     */
    TicketDetails getTicketDetails(String afid);

    /**
     * get ticket count
     * @param seatType
     * @param afid
     * @return
     */
    int getTicketCount(String seatType,String afid);
}

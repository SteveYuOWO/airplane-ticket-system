package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TicketDetailsRepository;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ticket details service
 */
@Service
public class TicketDetailsServiceImpl implements TicketDetailsService{

    /**
     * ticket details repository
     */
    @Autowired
    private TicketDetailsRepository ticketDetailsRepository;

    /**
     *  get Ticket Details by afid
     * @param afid
     * @return
     */
    @Override
    public TicketDetails getTicketDetails(String afid) {
        return ticketDetailsRepository.getTicketDetailByAfId(afid);
    }

    /**
     * get Ticket Count
     */
    @Override
    public int getTicketCount(String seatType,String afid){ return ticketDetailsRepository.getTicketCount(seatType,afid); }

}

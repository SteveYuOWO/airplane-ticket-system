package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.PlaneRepository;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketNumberServiceImpl implements TicketNumberService{

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private TicketDetailsService ticketDetailsService;

    @Override
    public void setTicketNumber(TicketDetails ticketDetails) {
        int h = ticketDetailsService.getTicketCount("h", ticketDetails.getAfid());
        int b = ticketDetailsService.getTicketCount("b", ticketDetails.getAfid());
        int t = ticketDetailsService.getTicketCount("t", ticketDetails.getAfid());
    }
}

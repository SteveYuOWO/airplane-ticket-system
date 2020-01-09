package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.PlaneRepository;
import com.littlepage.airplaneticketsystem.pojo.Plane;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ticket Number Service impl
 */
@Service
public class TicketNumberServiceImpl implements TicketNumberService{

    /**
     * plane repository
     */
    @Autowired
    private PlaneRepository planeRepository;

    /**
     * ticket details service
     */
    @Autowired
    private TicketDetailsService ticketDetailsService;

    /**
     * set ticket number
     * @param ticketDetails
     */
    @Override
    public void setTicketNumber(TicketDetails ticketDetails) {
        int h = ticketDetailsService.getTicketCount("h", ticketDetails.getAfid());
        int b = ticketDetailsService.getTicketCount("b", ticketDetails.getAfid());
        int t = ticketDetailsService.getTicketCount("t", ticketDetails.getAfid());
        Plane plane = planeRepository.getPlaneByAfid(ticketDetails.getAfid());
        ticketDetails.setBusinessRelease(plane.getBusinessnum()-b);
        ticketDetails.setFirstRelease(plane.getSeatNum()-plane.getBusinessnum()-plane.getTouristNum()-h);
        ticketDetails.setTouristRelease(plane.getTouristNum()-t);
    }
}

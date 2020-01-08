package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.vojo.TicketDetails;

public interface TicketDetailsService {
    TicketDetails getTicketDetails(String afid);
    int getTicketCount(String seatType,String afid);
}

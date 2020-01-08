package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;

import java.util.ArrayList;

public interface TodayTicketService {
    ArrayList<TodayTicketSimple> getTodayTicket(Page pageable);
}

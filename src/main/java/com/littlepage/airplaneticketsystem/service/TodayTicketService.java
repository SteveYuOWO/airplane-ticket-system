package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * today ticket service
 * for the index page
 */
public interface TodayTicketService {
    /**
     * ticket
     * @param pageable
     * @return
     */
    List<TodayTicketSimple> getTodayTicket(Page pageable);
}

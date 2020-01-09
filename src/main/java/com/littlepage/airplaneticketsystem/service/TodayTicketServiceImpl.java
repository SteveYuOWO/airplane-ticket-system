package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TodayTicketSimpleRepository;
import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * today ticket service impl
 */
@Service
public class TodayTicketServiceImpl implements TodayTicketService{
    /**
     * today ticket simple repository
     */
    @Autowired
    private TodayTicketSimpleRepository todayTicketSimpleRepository;

    /**
     * get today ticket
     * @param page
     * @return
     */
    @Override
    public List<TodayTicketSimple> getTodayTicket(Page page) {
        return todayTicketSimpleRepository.showAllData(page);
    }
}

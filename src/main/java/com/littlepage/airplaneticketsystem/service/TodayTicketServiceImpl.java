package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TodayTicketSimpleRepository;
import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodayTicketServiceImpl implements TodayTicketService{
    @Autowired
    private TodayTicketSimpleRepository todayTicketSimpleRepository;

    @Override
    public ArrayList<TodayTicketSimple> getTodayTicket(Page page) {
        return todayTicketSimpleRepository.showAllData(page);
    }
}

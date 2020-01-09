package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TicketRepository;
import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ticket service impl
 */
@Service
public class TicketServiceImpl implements TicketService {
    /**
     * ticket repository
     */
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * add ticket method
     * @param ticket
     */
    @Override
    public void buyTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    /**
     * get ticket num
     * @param afid
     * @return
     */
    @Override
    public Integer getTicketNum(String afid) {
        return ticketRepository.getTicketNum(afid);
    }

    /**
     * get ticket by uid and afid
     * @param uid
     * @param afid
     * @return
     */
    @Override
    public Ticket getTicketByUidAndAfid(String uid, String afid) {
        return ticketRepository.searchTicketByUidAndAfid(uid,afid);
    }

    /**
     * get tickets by user
     * @param user
     * @return
     */
    @Override
    public List<Ticket> getTicketsByUser(User user) {
        return ticketRepository.getTicketByUid(user.getUid());
    }

    /**
     * remove tickets
     * @param tid
     * @return
     */
    @Override
    public boolean removeTicketByTid(String tid) {
        Ticket ticket = ticketRepository.getTicketByTid(tid);
        if(ticket==null) return false;
        ticketRepository.removeTicket(tid);
        return true;
    }
}

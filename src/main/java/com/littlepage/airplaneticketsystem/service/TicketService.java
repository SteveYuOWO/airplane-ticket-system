package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.pojo.User;

import java.util.List;

/**
 * ticket service
 */
public interface TicketService {
    /**
     * buy ticket method
     * @param ticket
     */
    void buyTicket(Ticket ticket);

    /**
     * get ticket num
     * @param afid
     */
    Integer getTicketNum(String afid);

    /**
     * get ticket
     * @param uid
     * @param afid
     * @return
     */
    Ticket getTicketByUidAndAfid(String uid, String afid);

    /**
     * get user's tickets
     * @param user
     * @return
     */
    List<Ticket> getTicketsByUser(User user);

    /**
     * remove ticket
     * @param tid
     */
    boolean removeTicketByTid(String tid);

    /**
     * get ticket by tid
     * @param tid
     * @return
     */
    Ticket getTicketByTid(String tid);

}

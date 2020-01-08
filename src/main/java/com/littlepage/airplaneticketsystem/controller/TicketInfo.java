package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.service.TicketDetailsService;
import com.littlepage.airplaneticketsystem.service.TicketNumberService;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("info")
public class TicketInfo {

    @Autowired
    private TicketDetailsService ticketDetailsService;

    @Autowired
    private TicketNumberService ticketNumberService;

    @RequestMapping("ticketInfo")
    public String ticketInfo(String afid, Model model){
        /**
         * get ticket Details
         */
        TicketDetails ticketDetails = ticketDetailsService.getTicketDetails(afid);
        /**
         * hidden middle airline code
         */
        ticketDetails.setAlid(ticketDetails.getAlid().substring(0,4)+
                "**"+ticketDetails.getAlid().substring(ticketDetails.getAlid().length() -4));
        /**
         * set release ticket number
         *
         * all ticket number - count purchased ticket number
         */
        ticketNumberService.setTicketNumber(ticketDetails);
        model.addAttribute("ticket",ticketDetails);
        return "ticketInfo";
    }
}

package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.service.TicketDetailsService;
import com.littlepage.airplaneticketsystem.service.TicketNumberService;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * ticket Info
 */
@Controller
@RequestMapping("info")
public class TicketInfo {

    /**
     * ticket detail service
     */
    @Autowired
    private TicketDetailsService ticketDetailsService;

    /**
     * ticket number service
     */
    @Autowired
    private TicketNumberService ticketNumberService;

    /**
     * ticket info
     * @param afid the id of air flight
     * @param model model
     * @return ticket info page
     */
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

    /**
     * buy method
     * @param type
     * @param afid
     * @param httpSession
     * @param model
     * @return
     */
    @GetMapping("buy/{type}/{afid}")
    @ResponseBody
    public String buy(@PathVariable String type,
                      @PathVariable String afid,
                      HttpSession httpSession,
                      Model model){
        User user = (User)httpSession.getAttribute("user");
        System.out.println(user);
        System.out.println(type+"------"+afid);
        return "";
    }
}

package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.service.TicketDetailsService;
import com.littlepage.airplaneticketsystem.service.TicketNumberService;
import com.littlepage.airplaneticketsystem.service.TicketService;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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

    @Autowired
    private TicketService ticketService;

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
    public String buy(@PathVariable String type,
                      @PathVariable String afid,
                      HttpSession httpSession,
                      Model model, RedirectAttributes attributes){
        User user = (User)httpSession.getAttribute("user");
        Ticket ticket = new Ticket();
        TicketDetails ticketDetails = ticketDetailsService.getTicketDetails(afid);
        /**
         * 剩余票数
         */
        if((type.equals("h")&&ticketDetails.getFirstRelease()==0)&&
                (type.equals("b")&&ticketDetails.getBusinessRelease()==0)&&
                (type.equals("t")&&ticketDetails.getTouristRelease()==0)){
            attributes.addFlashAttribute("message","购买失败");
            return "redirect:/info/purchaseResult";
        }
        ticket.setTID(UUID.randomUUID().toString()).setPurchaseTime(new Date()).
                setSeatNum(ticketService.getTicketNum(afid)+1).setSeatType(type).setUid(user.getUid()).
                setAfid(afid);
        ticketService.buyTicket(ticket);
        attributes.addFlashAttribute("message","购买成功");
        return "redirect:/info/purchaseResult";
    }

    /**
     * purchaseResult
     * @return
     */
    @RequestMapping("purchaseResult")
    public String purchaseResult(){
        return "result";
    }
}

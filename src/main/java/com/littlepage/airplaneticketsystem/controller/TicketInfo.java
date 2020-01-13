package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.dao.AirflightRepository;
import com.littlepage.airplaneticketsystem.dao.PlaneRepository;
import com.littlepage.airplaneticketsystem.pojo.Ticket;
import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.service.*;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ticket Info
 */
@Controller
@RequestMapping("info")
public class TicketInfo {
    /**
     * user service
     */
    @Autowired
    private UserService userService;

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
     * ticket service
     */
    @Autowired
    private TicketService ticketService;

    /**
     * vipService
     */
    @Autowired
    private VipService vipService;

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
                      Model model, RedirectAttributes attributes,
                      HttpSession session){
        User user = (User)httpSession.getAttribute("user");
        Ticket ticket = new Ticket();
        TicketDetails ticketDetails = ticketDetailsService.getTicketDetails(afid);
        /**
         * release ticket
         */
        if((type.equals("h")&&ticketDetails.getFirstRelease()==0)&&
                (type.equals("b")&&ticketDetails.getBusinessRelease()==0)&&
                (type.equals("t")&&ticketDetails.getTouristRelease()==0)){
            attributes.addFlashAttribute("message","购买失败");
            return "redirect:/info/purchaseResult";
        }
        /**
         * one person should have one same ticket
         */
        if(ticketService.getTicketByUidAndAfid(user.getUid(),afid)!=null){
            attributes.addFlashAttribute("message","不能重复购票");
            return "redirect:/info/purchaseResult";
        }
        /**
         * add consume_money
         */
        vipService.consumeMoney(user.getUsername(),afid,type);
        ticket.setTID(UUID.randomUUID().toString()).setPurchaseTime(new Date()).
                setSeatNum(ticketService.getTicketNum(afid)+1).setSeatType(type).setUid(user.getUid()).
                setAfid(afid);
        ticketService.buyTicket(ticket);
        attributes.addFlashAttribute("message","购买成功");

        User updateUser = userService.findUser(user.getUsername());
        session.setAttribute("user",updateUser);
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

    /**
     * my ticket
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping("myticket")
    public String myticket(HttpSession httpSession,Model model){
        User user = (User)httpSession.getAttribute("user");
        List<Ticket> li=ticketService.getTicketsByUser(user);
        model.addAttribute("mytickets",li);
        return "myticket";
    }

    /**
     * remove by tid
     * @param tid
     * @param model
     * @return
     */
    @GetMapping("remove/{tid}")
    public String removeTicket(@PathVariable String tid, Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        ticketService.removeTicketByTid(tid);
        model.addAttribute("message","退票成功");
        return "result";
    }
}

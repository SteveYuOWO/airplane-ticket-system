package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.service.AirflightService;
import com.littlepage.airplaneticketsystem.service.TodayTicketService;
import com.littlepage.airplaneticketsystem.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Index {

    @Autowired
    private AirflightService airflightService;

    @Autowired
    private TodayTicketService todayTicketService;

    /**
     * index page
     * @return
     */
    @RequestMapping
    public String index(Model model){
        Page page = new Page();
        page.setPageNumber(airflightService.countAirflightService()/10).
                setPageSize(10).
                setIndex(0);
        model.addAttribute("airflightcount",airflightService.countAirflightService());
        model.addAttribute("todayTicket",todayTicketService.getTodayTicket(page));
        model.addAttribute("page",page);
        return "index";
    }

    @RequestMapping("/index{pageIndex}")
    public String index(Model model, int pageIndex){
        Page page = new Page();
        page.setPageNumber(airflightService.countAirflightService()/10).
                setPageSize(10);
        /**
         * head page and tail page solution
         */
        if(pageIndex < 0) {
            pageIndex = 0;
        }
        if(pageIndex > page.getPageNumber()) {
            pageIndex = page.getPageNumber();
        }
        page.setIndex(pageIndex);
        model.addAttribute("airflightcount",airflightService.countAirflightService());
        model.addAttribute("todayTicket",todayTicketService.getTodayTicket(page));
        model.addAttribute("page",page);
        return "index";
    }
}

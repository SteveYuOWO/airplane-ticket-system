package com.littlepage.airplaneticketsystem.controller;

import com.littlepage.airplaneticketsystem.service.SearchService;
import com.littlepage.airplaneticketsystem.utils.Page;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * search page controllers
 */
@Controller
@RequestMapping("search")
public class SearchPlace {
    /**
     * search service
     */
    @Autowired
    private SearchService searchService;

    /**
     * search Info
     * @param startPlace
     * @param arrivePlace
     * @param searchDate
     * @return
     */
    @PostMapping("place")
    public String searchInfo(String startPlace, String arrivePlace, String searchDate,
                             Model model, RedirectAttributes attributes){
        List<TodayTicketSimple> todayTicketSimples = null;
        if(searchDate==null||searchDate.equals("")){
            todayTicketSimples = searchService.searchAirflights(startPlace, arrivePlace);
        }else {
            todayTicketSimples = searchService.searchAirflights(startPlace,arrivePlace,searchDate);
        }
        model.addAttribute("airflightcount",todayTicketSimples.size());
        model.addAttribute("todayTicket",todayTicketSimples);
        Page page = new Page();
        page.setPageNumber(0).
                setPageSize(todayTicketSimples.size()).setIndex(0);
        model.addAttribute("page",page);
        model.addAttribute("title","查询结果");
        return "index";
    }
}

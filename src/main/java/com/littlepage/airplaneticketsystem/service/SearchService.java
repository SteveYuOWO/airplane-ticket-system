package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * search service
 */
@Service
public interface SearchService {
    /**
     * search airflights
     * @param startPlace
     * @param endPlace
     * @return
     */
    List<TodayTicketSimple> searchAirflights(String startPlace, String endPlace);

    /**
     * search airflights
     * @param startPlace
     * @param endPlace
     * @param date
     * @return
     */
    List<TodayTicketSimple> searchAirflights(String startPlace, String endPlace, String date);
}

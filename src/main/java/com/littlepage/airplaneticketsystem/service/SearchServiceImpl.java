package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.TodayTicketSimpleRepository;
import com.littlepage.airplaneticketsystem.vojo.TodayTicketSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * search service implements
 */
@Service
public class SearchServiceImpl implements SearchService {
    /**
     * today ticket simple repository
     */
    @Autowired
    private TodayTicketSimpleRepository todayTicketSimpleRepository;

    /**
     * search airFlights by start time and end time
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<TodayTicketSimple> searchAirflights(String startTime, String endTime) {
        return todayTicketSimpleRepository.getTicketByStartPlaceAndArrivePlace(startTime,endTime);
    }

    /**
     * search airflights by startTime and endTime
     *
     * @param startPlace
     * @param endPlace
     * @param date
     * @return
     */
    @Override
    public List<TodayTicketSimple> searchAirflights(String startPlace, String endPlace, String date) {
        return todayTicketSimpleRepository.getTicketByStartPlaceAndArrivePlaceAndDate(startPlace,endPlace,date);
    }
}

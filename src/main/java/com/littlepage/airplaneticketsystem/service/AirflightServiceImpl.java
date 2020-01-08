package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.AirflightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The implement class of AirflightService
 */
@Service
public class AirflightServiceImpl implements AirflightService {

    @Autowired
    private AirflightRepository airflightRepository;

    /**
     * count airflight service
     * @return
     */
    @Override
    public int countAirflightService() {
        return airflightRepository.countAirflight();
    }
}

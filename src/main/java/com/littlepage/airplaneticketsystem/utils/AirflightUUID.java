package com.littlepage.airplaneticketsystem.utils;

import com.littlepage.airplaneticketsystem.dao.AirflightRepository;
import com.littlepage.airplaneticketsystem.pojo.Airflight;

/**
 * get a random airflight UUID like G3048
 *
 * The G is the first signal represent G-series high-speed train
 *
 * Then four random digital to confirm a unique value
 */
public class AirflightUUID {

    /**
     * validate is or not exist signal of Airflight
     */
    private static AirflightRepository airflightRepository = new AirflightRepository();

    /**
     * The algorithm of keep the unique Airflight UUID
     * @return
     */
    public static String getAirflightUUID(){
        String res = "G";
        res += (int)(Math.random()*10);
        res += (int)(Math.random()*10);
        res += (int)(Math.random()*10);
        res += (int)(Math.random()*10);
        if(airflightRepository.countAirflight(res)==0) return res;
        else return getAirflightUUID();
    }
}

package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.pojo.User;
import com.littlepage.airplaneticketsystem.vojo.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * vip service impl
 */
@Service
public class VipServiceImpl implements VipService {

    /**
     * ticket details service
     */
    @Autowired
    private TicketDetailsService ticketDetailsService;

    @Autowired
    private UserService userService;

    /**
     * add consume money
     * @param username
     * @param afid
     * @param type
     */
    @Override
    public void consumeMoney(String username, String afid, String type) {
        TicketDetails td = ticketDetailsService.getTicketDetails(afid);
        User user = userService.findUser(username);
        if(type.equals("h")){
            user.setConsumeMoney(user.getConsumeMoney()+td.getFirstPrice());
        }else if(type.equals("b")){
            user.setConsumeMoney(user.getConsumeMoney()+td.getBusinessPrice());
        }else {
            user.setConsumeMoney(user.getConsumeMoney()+td.getTouristPrice());
        }
        userService.updateMoney(user);
    }
}

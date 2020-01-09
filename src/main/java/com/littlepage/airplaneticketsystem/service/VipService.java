package com.littlepage.airplaneticketsystem.service;

/**
 * provide vip service
 */
public interface VipService {
    /**
     * consume money as user's score
     * @param username
     * @param afid
     * @param type
     */
    void consumeMoney(String username, String afid, String type);
}

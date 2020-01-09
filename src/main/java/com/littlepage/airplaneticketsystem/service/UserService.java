package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.pojo.User;

/**
 * Service for user login
 */
public interface UserService {
    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     */
    User findUser(String username, String password);

    /**
     * find user by username
     * @param username
     * @return
     */
    User findUser(String username);

    /**
     * add the user
     * @param uid
     * @param username
     * @param password
     */
    void addUser(String uid,String username, String password);

    /**
     * 更新user
     * @param user
     * @return
     */
    boolean updateUser(User user);
}

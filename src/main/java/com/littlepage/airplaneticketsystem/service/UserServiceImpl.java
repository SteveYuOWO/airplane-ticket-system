package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.UserRepository;
import com.littlepage.airplaneticketsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service impl
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * user repository
     */
    @Autowired
    UserRepository userRepository;

    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    /**
     * find user by username
     * @param username
     * @return
     */
    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * add user
     * @param uid
     * @param username
     * @param password
     */
    @Override
    public void addUser(String uid,String username, String password) {
        userRepository.addUser(uid,username,password);
    }

    /**
     * update user
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        if(userRepository.findByUsername(user.getUsername())==null){
            return false;
        }
        userRepository.updateUser(user);
        return true;
    }

    /**
     * update money
     * @param user
     */
    @Override
    public void updateMoney(User user) {
        userRepository.updateMoney(user);
    }
}

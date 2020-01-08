package com.littlepage.airplaneticketsystem.service;

import com.littlepage.airplaneticketsystem.dao.UserRepository;
import com.littlepage.airplaneticketsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The implements of UserService
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(String uid,String username, String password) {
        userRepository.addUser(uid,username,password);
    }
}

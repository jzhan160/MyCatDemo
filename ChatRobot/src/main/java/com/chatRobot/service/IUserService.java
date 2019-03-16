package com.chatRobot.service;

import com.chatRobot.model.User;

import java.util.List;

public interface IUserService {

     User selectUser(long userId);
     List<User> selectAllUsers();
     void insertUser(User user);

}
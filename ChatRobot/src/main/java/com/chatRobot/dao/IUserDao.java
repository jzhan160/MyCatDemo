package com.chatRobot.dao;
import com.chatRobot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public interface IUserDao {

    User selectUser(long id);
    List<User> selectAllUsers();
    void insertUser(User user);
}
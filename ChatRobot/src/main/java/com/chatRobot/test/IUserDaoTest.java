package com.chatRobot.test;

import com.chatRobot.dao.IUserDao;
import com.chatRobot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = dao.selectUser(id);
        System.out.println(user.getUsername());
    }
    @Test
    public void testSelectAllUsers() throws Exception {
        List<User> users = dao.selectAllUsers();
        System.out.println(users);
    }
    @Test
    public void testInsertUser(){
        User user1 = new User();
        user1.setId(8);
        user1.setUsername("qi");
        dao.insertUser(user1);

        User user2 = new User();
        user2.setId(9);
        user2.setUsername("qi");
        dao.insertUser(user2);
    }

}
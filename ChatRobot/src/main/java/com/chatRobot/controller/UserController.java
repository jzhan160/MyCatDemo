package com.chatRobot.controller;
import javax.servlet.http.HttpServletRequest;
import com.chatRobot.model.User;
import com.chatRobot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public ModelAndView selectUser() throws IOException {
        User user = this.userService.selectUser(1);
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/showAllUsers.do")
    public ModelAndView selectAllUsers() throws IOException {
        List<User> userList = this.userService.selectAllUsers();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("userList",userList);
        return mv;
    }

}
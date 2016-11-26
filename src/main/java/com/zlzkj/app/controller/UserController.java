package com.zlzkj.app.controller;

import hziee.smvc.mapper.UserMapper;
import hziee.smvc.model.User;
import hziee.smvc.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
    @RequestMapping("/register")
    public String RegisterUser(User user, HttpServletRequest request, HttpServletResponse response){
        String hash=org.apache.commons.codec.digest.DigestUtils.md5Hex(user.getUserPasswordHash());
        user.setUserPasswordHash(hash);
        System.out.println(user.getUserEmail());
        userService.insert(user);
        request.getSession().setAttribute("user",user);
        return IndexController.index;
    }
    @RequestMapping("/login")
    public String Login(User user,HttpServletRequest request,HttpServletResponse response){
        User reuser = userService.getUser(user.getUserEmail(),user.getUserPasswordHash());
        request.getSession().setAttribute("user",reuser);
        return IndexController.index;
    }
    @RequestMapping("/logout")
        public String Logout(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            request.getSession().invalidate();
            request.getSession().setAttribute("logininfo","logout");
            return IndexController.index;
    }


}

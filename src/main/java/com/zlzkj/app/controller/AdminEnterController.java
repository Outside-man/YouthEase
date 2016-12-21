package com.zlzkj.app.controller;

import hziee.smvc.model.User;
import hziee.smvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminEnterController {
    @Autowired
    private ContactService contactService;
    @RequestMapping("/login")
    public String AdminLogin(User user, HttpServletRequest request, HttpServletResponse response){
        return  null;
    }
    @RequestMapping("/jump")
    public String JumpToAdmin(HttpServletRequest request, HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        if(user.getAuthority()==666){
         return IndexController.AdminJumpTo("index");
        }
        return null;
    }
    @RequestMapping("/*.html")
    public String TransPage(HttpServletRequest request,HttpServletResponse response){
        String s = request.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        if(result.equals("feedback")){
            request.setAttribute("list",contactService.getAllContact());
        }
        return "/"+IndexController.adminRoot+"/"+result;
    }
}

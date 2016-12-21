package com.zlzkj.app.controller;

import hziee.smvc.model.User;
import hziee.smvc.service.ContactService;
import hziee.smvc.service.PostService;
import hziee.smvc.service.UserService;
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
    @Autowired
    private  UserService userService;
    @Autowired
    private PostService postService;
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
            return "/"+IndexController.adminRoot+"/"+result;
        }
        if(result.equals("rank")){
            request.setAttribute("list", userService.GetAllUser());
            return "/"+IndexController.adminRoot+"/"+result;
        }
        if(result.equals("list")){
            request.setAttribute("list",postService.getAllForum());
            return "/"+IndexController.adminRoot+"/"+result;
        }
        String repart[] = result.split("[X]");
        System.out.println(repart.length);
        if(repart.length==2){
            if(repart[0].equals("updateuser")){
                Integer id = Integer.parseInt(repart[1]);
                request.setAttribute("u_user",userService.getUser(id));
            }
            return "/"+IndexController.adminRoot+"/"+repart[0];
        }

        return "/"+IndexController.adminRoot+"/"+result;
    }
}

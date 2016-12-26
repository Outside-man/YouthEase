package com.zlzkj.app.controller;

import hziee.smvc.model.Contact;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import hziee.smvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @Autowired
    private PageService pageService;
    @Autowired
    private PageContentService pageContentService;
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

        //访问的请求中有问号的时候
        String specialRe[] = result.split("[_]");
        Integer specialInt =null;
        if(specialRe.length>=2){
            result=specialRe[0];
            specialInt = Integer.parseInt(specialRe[1]);
        }
        List list;
        pageService.setContentPerCount(8);
        //分析问号
        if(result.equals("feedback")){

            request.setAttribute("list",list=pageContentService.getPagedContent(specialInt, Contact.class));
            request.setAttribute("pages",pageService.getPagesCount(contactService.getAllContact().size()));
            return "/"+IndexController.adminRoot+"/"+result;
        }
        if(result.equals("rank")){
            request.setAttribute("list",list=pageContentService.getPagedContent(specialInt, User.class));
            request.setAttribute("pages",pageService.getPagesCount(userService.getAllUser().size()));
            return "/"+IndexController.adminRoot+"/"+result;
        }
        if(result.equals("list")){
            request.setAttribute("list",list=pageContentService.getPagedContent(specialInt, Forum.class));
            request.setAttribute("pages",pageService.getPagesCount(postService.getAllForum().size()));

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

package com.zlzkj.app.controller;

import hziee.smvc.model.Comment;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import hziee.smvc.service.CommentService;
import hziee.smvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/post_forum")
    //暂时先完成感情贴的功能
    public String postText(Forum forum, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(forum);
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            user = new User();
        }
        //    return "/"+IndexController.root+"/"+"login";
        postService.AddNewForum(forum,user);
       return "redirect:/getforum_emotion";
    }
    @RequestMapping("/post_forum_admin")
    public String postTextAdmin(Forum forum, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(forum);
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            user = new User();
        }
        //    return "/"+IndexController.root+"/"+"login";
        postService.AddNewForum(forum,user);
        return "redirect:/admin/list_1.html";
    }
    @RequestMapping("/post_comment")
    public String postComment(Comment comment, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("comment userId is "+comment.getUserId());
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            user = new User();
        }
        commentService.AddNewComment(comment);
        return "redirect:/"+comment.getForumId()+".tie";
    }

}

package com.zlzkj.app.controller;

import hziee.smvc.model.Comment;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import hziee.smvc.service.CommentService;
import hziee.smvc.service.PostService;
import hziee.smvc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    ResourceService resourceService;
    @RequestMapping("/post_forum")
    //暂时先完成感情贴的功能
    public String postText(Forum forum, @RequestParam("addon") MultipartFile file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        System.out.println(forum);
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            user = new User();
        }
        //    return "/"+IndexController.root+"/"+"login";
        postService.AddNewForum(forum,user);
        System.out.println(forum.getId());
        System.out.println("forum is:"+forum);
        if(file!=null){
            String filename=resourceService.UploadMedia(file,forum.getId(),httpServletRequest);
            if(filename==null)
                return "redirect:/"+forum.getTypes()+".forum";
            String parts[]= filename.split("[.]");
   /*
   VIDEO_EXT=mp4,avi,mkv,flv,mpg,mpeg,wmv
#supported image ext name list
IMAGE_EXT=jpg,jpeg,png,bmp,gif
    */
   System.out.println("element type:"+parts[1]);
            if(parts[1].equals("jpg")||parts[1].equals("png")||parts[1].equals("jpeg")||parts[1].equals("bmp")||parts[1].equals("gif"))
                forum.setAdditionId(1);
            if(parts[1].equals("mp4")||parts[1].equals("ogg"))
                forum.setAdditionId(2);
            forum.setAdditionStatus(filename);
            forum = postService.UpdateForum(forum);
        }
       return "redirect:/"+forum.getTypes()+".forum";
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

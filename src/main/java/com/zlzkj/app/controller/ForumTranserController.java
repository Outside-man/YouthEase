package com.zlzkj.app.controller;
import java.util.List;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.Comment;
import hziee.smvc.model.Forum;
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
public class ForumTranserController extends BaseController{
    @Autowired
    public PostService postService;
    @Autowired
    public CommentService commentService;
    @RequestMapping("/getforum_emotion")
    public String getForum(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List list = postService.GetTypesOfForum("emotion");
        httpServletRequest.getSession().setAttribute("forum", list);
        return "/" + IndexController.root + "/" + "emotion";
    }
    @RequestMapping("/*.tie")
    public String getText(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String s =  httpServletRequest.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        Integer id = Integer.parseInt(result);
        Forum  forum  = postService.getForumFromId(id);
        httpServletRequest.setAttribute("forum", forum);
        httpServletRequest.setAttribute("list",commentService.GetCommentsOfForum(forum.getId()));
        return "/"+ IndexController.root + "/" + "tie";
    }
}

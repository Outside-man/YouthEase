package com.zlzkj.app.controller;
import java.util.List;

import hziee.smvc.model.Forum;
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
public class ForumTranserController {
    @Autowired
    public PostService postService;
    @RequestMapping("/getforum_emotion")
    public String getForum(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List list = postService.GetTypesOfForum("emotion");
        httpServletRequest.getSession().setAttribute("forum", list);
        return "/" + IndexController.root + "/" + "emotion";
    }
    @RequestMapping("/*.tie")
    public String getText(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("超级强的servlet");
        String s =  httpServletRequest.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        Integer id = Integer.parseInt(result);
        System.out.println("来看看有么有解析出结果:"+id);
        Forum  forum  = postService.getForumFromId(id);
        System.out.println("对我就是在用这种原始的DEBUG方式:"+forum);
        httpServletRequest.getSession().setAttribute("forum", forum);
        return "/"+ IndexController.root + "/" + "tie";
    }
}

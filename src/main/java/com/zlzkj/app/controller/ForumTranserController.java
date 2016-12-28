package com.zlzkj.app.controller;
import java.util.List;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.Comment;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import hziee.smvc.service.*;
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
    @Autowired
    public UserService userService;
    @Autowired
    private  ResourceService resourceService;
    @Autowired
    private PicService picService;
    @Autowired
    private  MediaService mediaService;
    @Autowired
    private PageContentService pageContentService;
    @RequestMapping("/*.forum")
    public String getForum(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String s =  httpServletRequest.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        List list = postService.GetTypesOfForum(result);
        httpServletRequest.getSession().setAttribute("forum", list);
        return "/" + IndexController.root + "/" + result;
    }
    @RequestMapping("/*.tie")
    public String getText(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String s =  httpServletRequest.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        Integer id = Integer.parseInt(result);
        Forum  forum  = postService.getForumFromId(id);
        httpServletRequest.setAttribute("forum", forum);
        httpServletRequest.setAttribute("masteruser",userService.getUser(forum.getUserId()));
        httpServletRequest.setAttribute("list",commentService.GetCommentsOfForum(forum.getId()));
        httpServletRequest.setAttribute("masterIconUrl",picService.getIconUrl(forum.getUserId()));
        if(forum.getAdditionId()!=null&&forum.getAdditionId()!=0)
            httpServletRequest.setAttribute("additionUrl",mediaService.getMediaUrl(forum.getId()));
        return "/"+ IndexController.root + "/" + "tie";
    }
    @RequestMapping("/*.myforum")
    public String  getText(HttpServletRequest httpServletRequest){
        String s =  httpServletRequest.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        System.out.println("test");
        String specialRe[] = result.split("[_]");
        User user = userService.getUser(Integer.parseInt(specialRe[0]));
        httpServletRequest.setAttribute("centerUser",user);
        Integer pages = Integer.parseInt(specialRe[1]);
        System.out.println(pages);
        httpServletRequest.setAttribute("pages",pages);
        List list = pageContentService.getPageContentExact(pages,Forum.class,"user_id="+user.getId());
        System.out.println(list.size());
        httpServletRequest.setAttribute("forum",list);
        return "/"+ IndexController.root + "/" + "mytie";
    }
}

package com.zlzkj.app.controller;
import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.MessageService;
import hziee.smvc.service.PicService;
import hziee.smvc.service.PostService;
import hziee.smvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/14.
 */
@Controller
public class SelfCenterController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private PicService picService;
    @Autowired
    private PostService postService;
    @Autowired
    private MessageService messageService;
    @RequestMapping("/self_center_p/*")
    public String trans(HttpServletRequest request, HttpServletResponse response)
    {
        String s = request.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 1];
        User thisUser=null;
        if(result.equals("self")){
            thisUser = (User) request.getSession().getAttribute("user");
            request.setAttribute("messages",messageService.GetUsersMessage(thisUser.getId()));
        }else{
            Integer id = Integer.parseInt(result);
            thisUser= userService.getUser(id);
        }
        request.setAttribute("forum",postService.GetUsersForum(thisUser.getId()));
        request.setAttribute("centerUser",thisUser);

        request.setAttribute("iconUrl",picService.getIconUrl(thisUser));
        return "/"+IndexController.root+"/"+"self_center";
    }
}

package com.zlzkj.app.controller;
import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.*;
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
    @Autowired
    private FriendService friendService;
    @RequestMapping("/self_center_p/*")
    public String trans(HttpServletRequest request, HttpServletResponse response)
    {
        String s = request.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 1];
        User thisUser=null;
        User visitor = (User) request.getSession().getAttribute("user");
        if(result.equals("self")){
            thisUser = (User) request.getSession().getAttribute("user");
            request.setAttribute("messages",messageService.GetUsersMessage(thisUser.getId()));
        }else{
            Integer id = Integer.parseInt(result);
            thisUser= userService.getUser(id);
            if(friendService.HasFriend(thisUser.getId(),visitor.getId())){
                request.setAttribute("befriend",true);
            }else{
                request.setAttribute("befriend",false);
            }
        }
        request.setAttribute("forum",postService.GetUsersForum(thisUser.getId()));
        request.setAttribute("centerUser",thisUser);
        request.setAttribute("friends",friendService.GetFriendOfUser(thisUser.getId()));
        request.setAttribute("iconUrl",picService.getIconUrl(thisUser));
        return "/"+IndexController.root+"/"+"self_center";
    }
}

package com.zlzkj.app.controller;
import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.PicService;
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
    @RequestMapping("/self_center_p/*")
    public String trans(HttpServletRequest request, HttpServletResponse response)
    {
        String s = request.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 1];
        User thisUser=null;
        if(result.equals("self")){
            thisUser = (User) request.getSession().getAttribute("user");
        }else{
            Integer id = Integer.parseInt(result);
            thisUser= userService.getUser(id);
        }
        request.getSession().setAttribute("centerUser",thisUser);
        request.getSession().setAttribute("iconUrl",picService.getIconUrl(thisUser));
        return "/"+IndexController.root+"/"+"self_center";
    }



}

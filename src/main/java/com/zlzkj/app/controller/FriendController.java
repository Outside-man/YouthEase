package com.zlzkj.app.controller;

import hziee.smvc.model.Message;
import hziee.smvc.model.User;
import hziee.smvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private  MessageService messageService;
    @RequestMapping("/add")
    public String AddFriend(Message message, HttpServletRequest request, HttpServletResponse response){
        User sourceUser = (User)request.getSession().getAttribute("user");
        message.setContent("用户"+sourceUser.getNuserName()+"请求加你为好友");
        messageService.NewMessage(message,"friend_making");
        return "redirect:/self_center_p/self";
    }


}

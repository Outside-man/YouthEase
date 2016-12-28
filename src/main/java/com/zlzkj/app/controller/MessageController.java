package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.Message;
import hziee.smvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/22.
 */
@RequestMapping("/message")
@Controller
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;
    @RequestMapping("/del_friend_request")
    @ResponseBody
    public String DelFriendRequest(@RequestParam("msgid")String id, HttpServletResponse response){
        Message thismesaage= messageService.GetMessage(Integer.parseInt(id));
        messageService.DeleteMessage(Integer.parseInt(id));
        return ajaxReturn(response,messageService.GetUsersMessage(thismesaage.getTargetId()));
    }
    @RequestMapping("/send")

    public String SendMessage(Message message, HttpServletResponse response){
        if(message.getType().equals("etalk")){
            messageService.NewMessage(message);
        }
        return "redirect:/etalkto/"+message.getTargetId()+".user";
    }

}

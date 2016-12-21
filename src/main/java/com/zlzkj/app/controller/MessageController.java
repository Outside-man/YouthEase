package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
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
        messageService.DeleteMessage(Integer.parseInt(id));
        return ajaxReturn(response,null);
    }
}

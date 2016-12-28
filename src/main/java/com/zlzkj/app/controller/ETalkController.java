package com.zlzkj.app.controller;

import com.zlzkj.core.sql.Row;
import hziee.smvc.model.Comment;
import hziee.smvc.model.Message;
import hziee.smvc.model.User;
import hziee.smvc.service.CommentService;
import hziee.smvc.service.FriendService;
import hziee.smvc.service.MessageService;
import hziee.smvc.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28.
 */
@Controller
@RequestMapping("/etalkto/*")
public class ETalkController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private PicService picService;
    @Autowired
    private MessageService messageService;
    @RequestMapping("/*.user")
    public String ETalkTo(String id, HttpServletRequest request){

        String s =  request.getRequestURI();
        String part[] =  s.split("[.|/]");
        String result = part[part.length - 2];
        Integer targetId = Integer.parseInt(result);
        List<Row> list = new ArrayList<>();
        User user = (User)request.getSession().getAttribute("user");
        List<User> users  =friendService.GetFriendOfUser(user.getId());
        for(User fri:users){
            Row m  = new Row();
            m.put("friend",fri);
            m.put("icon",picService.getIconUrl(fri.getId()));
            list.add(m);
        }
        List<Message> messages = messageService.GetUserMessage(user.getId(),targetId);
        request.setAttribute("list",list);

        if(targetId==-1){
            return "/" + IndexController.root + "/etalk";
        }else{
            request.setAttribute("messages",messages);
        }
        return "/" + IndexController.root + "/etalk";
    }
}

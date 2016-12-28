package com.zlzkj.app.controller;

import com.zlzkj.core.sql.Row;
import hziee.smvc.model.Comment;
import hziee.smvc.model.Message;
import hziee.smvc.model.User;
import hziee.smvc.service.*;
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
            m.put("user",fri);
            if(fri.getId()==targetId){
                request.setAttribute("targetIcon",picService.getIconUrl(fri.getId()));
                request.setAttribute("t_username",user.getNuserName());
            }
            m.put("icon",picService.getIconUrl(fri.getId()));
            list.add(m);
        }
        request.setAttribute("list",list);

        if(targetId==-1){
            return "/" + IndexController.root + "/etalk";
        }else{
            List<Message> messages = messageService.GetUserMessage(user.getId(),targetId);
            request.setAttribute("messages",messages);
            request.setAttribute("target",targetId);
        }
        return "/" + IndexController.root + "/etalk";
    }
}

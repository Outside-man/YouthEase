package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.Message;
import hziee.smvc.model.User;
import hziee.smvc.service.FriendService;
import hziee.smvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
@RequestMapping("/friend/*")
public class FriendController extends BaseController{
    @Autowired
    private  MessageService messageService;
    @Autowired
    private FriendService friendService;

    @RequestMapping("/add")
    public String AddFriend(Message message, HttpServletRequest request, HttpServletResponse response){
        User sourceUser = (User)request.getSession().getAttribute("user");
            message.setContent("用户"+sourceUser.getNuserName()+"请求加你为好友");
            messageService.NewMessage(message,"friend_making");

        return "redirect:/self_center_p/self";
    }

    @RequestMapping("/agr")
    @ResponseBody
    public String Agree(@RequestParam("FriendPair")String paras[], HttpServletResponse request, HttpServletResponse response){
        System.out.println("test");
        if(paras.length!=3){
            System.out.println("not legal");
            return ajaxReturn(response,null);
        }else{
            System.out.println("just be friend");
            friendService.BecomeFriend(Integer.parseInt(paras[0]),Integer.parseInt(paras[1]));
            messageService.DeleteMessage(Integer.parseInt(paras[2]));
        }
        return ajaxReturn(response,null);
    }
    @RequestMapping("/del")
    @ResponseBody
    public String Delete(@RequestParam("FriendPair")String paras[], HttpServletResponse request, HttpServletResponse response){
        System.out.println("test");
        if(paras.length!=2){
            return ajaxReturn(response,null);
        }else{
            Integer id = Integer.parseInt(paras[0]);
            Integer id2 = Integer.parseInt(paras[1]);
            friendService.DeFriends(id,id2);
        }
        return ajaxReturn(response,null);
    }
}

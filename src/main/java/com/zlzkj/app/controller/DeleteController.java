package com.zlzkj.app.controller;

import com.alibaba.fastjson.JSONArray;
import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/16.
 */
@Controller
@RequestMapping("/delete/*")
public class DeleteController extends BaseController{
    @Autowired
    private ContactService contactService;
    @RequestMapping(value = "/contact", method = {RequestMethod.POST})
    @ResponseBody
    public String DelectContact(@RequestParam("DeleteList")String params[], HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        if(user==null||user.getAuthority()!=666) {
            return null;
        }
        System.out.println("进入DeleteContact");
        System.out.println(params.length);
        for(String id:params){
            System.out.println(id);
            Integer  i = Integer.parseInt(id);

            contactService.DeleteContatc(i);
        }
        System.out.println("退出循环");
        return ajaxReturn(httpServletResponse,contactService.getAllContact());
        }
}

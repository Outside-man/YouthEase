package com.zlzkj.app.controller;

import com.sun.tools.javac.util.List;
import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String DelectContact(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        if(user==null||user.getAuthority()!=666) {
            return null;
        }
        System.out.println(user);
        String id = httpServletRequest.getParameter("deleteId");
        if(id==null){
            List<Integer> list = (List)httpServletRequest.getParameterMap();
                    for(Integer i:list){
                        contactService.DeleteContatc(i);
                    }
             }else{
                contactService.DeleteContatc(Integer.parseInt(id));
            }

        return ajaxReturn(httpServletResponse,contactService.getAllContact());
        }


}

package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */

@RequestMapping("/search/*")
@Controller
public class SearchController extends BaseController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public String SearchUser(String keywords, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.print("进入搜索");
        List list  = userService.GetMatchedUser(keywords);

        httpServletRequest.setAttribute("list", list);
        System.out.print("退出搜索");
        return "/"+IndexController.adminRoot+"/rank";
    }
}

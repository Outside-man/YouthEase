package com.zlzkj.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/11/26.
 */
@Controller
@RequestMapping("/redirect")
public class RedirectController {
    @RequestMapping("/*")
    public String red(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getRequestURI());
        String s=request.getRequestURI();
       String part[]=s.split("/");
      return IndexController.root+"/"+part[part.length-1];
    }

}

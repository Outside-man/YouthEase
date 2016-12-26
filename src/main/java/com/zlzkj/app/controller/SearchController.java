package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.User;
import hziee.smvc.service.PageContentService;
import hziee.smvc.service.PageService;
import hziee.smvc.service.SearchService;
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
    @Autowired
    private PageService pageService;
    @Autowired
    private PageContentService pageContentService;
    @Autowired
    private SearchService searchService;
    @RequestMapping("/user")
    public String SearchUser(String keywords,String types, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.print("进入搜索");
        if(keywords.trim().equals("".trim())){
            httpServletRequest.setAttribute("search", false);
            return "redirect:/admin/rank_1.html";

        }
        List list  = pageContentService.getPagedContent(1,User.class,types+"="+keywords);
        httpServletRequest.setAttribute("pages",pageService.getPagesCount(userService.GetMatchedUser(keywords,types).size()));
        httpServletRequest.setAttribute("list", list);
        httpServletRequest.setAttribute("search", true);
        httpServletRequest.setAttribute("search_info",types+"="+keywords);
        System.out.print("退出搜索");
        return "/"+IndexController.adminRoot+"/rank";
    }
    @RequestMapping("/*.html")
    public String SearchFor(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始搜索");
        Class<?> contentClass = searchService.GetSearchedContetType(request.getRequestURI());
        List list =searchService.SearchServices(request.getRequestURI(),contentClass);
        String condtion[]= searchService.GetKeywords(request.getRequestURI());
        request.setAttribute("list",list);
        System.out.println("listsize:"+list.size());
        request.setAttribute("pages",pageService.getPagesCount(userService.GetMatchedUser(condtion[1],condtion[0]).size()));
        request.setAttribute("search", true);
        request.setAttribute("search_info",condtion[0]+"="+condtion[1]);
        return "/"+IndexController.adminRoot+"/rank";
    }
}

package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import hziee.smvc.model.Forum;
import hziee.smvc.model.User;
import hziee.smvc.service.*;
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
        if(keywords.trim().equals("".trim())){
            httpServletRequest.setAttribute("search", false);
            return "redirect:/admin/rank_1.html";
        }
        List list  = pageContentService.getPagedContent(1,User.class,types+"="+keywords);
        httpServletRequest.setAttribute("pages",pageService.getPagesCount(userService.GetMatchedUser(keywords,types).size()));
        httpServletRequest.setAttribute("list", list);
        httpServletRequest.setAttribute("search", true);
        httpServletRequest.setAttribute("search_info",types+"="+keywords);
        return "/"+IndexController.adminRoot+"/rank";
    }
    @RequestMapping("/forum")
    public String SearchForum(String keywords,String types, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.print("12345679879");
        if(keywords.trim().equals("".trim())){
            httpServletRequest.setAttribute("search", false);
            return "redirect:/admin/list_1.html";
        }

        List list  = pageContentService.getPagedContent(1,Forum.class,types+"="+keywords);
        httpServletRequest.setAttribute("pages",pageService.getPagesCount(pageContentService.GetAllMatched(types,keywords,Forum.class).size()));
        httpServletRequest.setAttribute("list", list);
        httpServletRequest.setAttribute("search", true);
        httpServletRequest.setAttribute("search_info",types+"="+keywords);


        return "/"+IndexController.adminRoot+"/list";
    }
    @RequestMapping("/*.html")
    public String SearchFor(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始搜索");

        String part[] =  request.getRequestURI().split("[.|/]");
        String result = part[part.length - 2];
        String resultPart[]= result.split("[_]");


        Class<?> contentClass = searchService.GetSearchedContentType(resultPart);
        List list =searchService.SearchServices(resultPart,contentClass);
        String condition[]= searchService.GetKeywords(resultPart);



        request.setAttribute("list",list);
        request.setAttribute("pages",pageService.getPagesCount(pageContentService.GetAllMatched(condition[0],condition[1],contentClass).size()));
        request.setAttribute("search", true);
        request.setAttribute("search_info",condition[0]+"="+condition[1]);


        String returnResult = resultPart[0];
        if(returnResult.equals("forum")){
            returnResult= "list";
        }
        if(returnResult.equals("contact")){
            returnResult= "feedback";
        }


        return "/"+IndexController.adminRoot+"/"+returnResult;
    }
}

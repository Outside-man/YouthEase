package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import com.zlzkj.core.util.UploadUtils;
import hziee.smvc.mapper.UserMapper;
import hziee.smvc.model.User;
import hziee.smvc.service.PicService;
import hziee.smvc.service.UserService;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/25.
 */

@Controller
@RequestMapping("/user")
public class UserController  extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private PicService  picService;
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
    @RequestMapping("/register")
    public String RegisterUser(User user, HttpServletRequest request, HttpServletResponse response){

        if(userService.UserExisted(user.getEmail())){
            return "/"+ IndexController.index;
        }

        User operator = (User)request.getSession().getAttribute("user");
        userService.NewUser(user);
        if(operator==null)
        return "/"+IndexController.index;
        else return "redirect:/admin/rank_1.html";
    }
    @RequestMapping("/login")
    public String Login(User user,HttpServletRequest request,HttpServletResponse response){
        User reuser = userService.getUser(user.getEmail(),user.getPasswordHash());
     //   System.out.println(user.getPasswordHash());
        if(reuser==null)
            return "/"+IndexController.root+"/"+"register";
        request.getSession().setAttribute("user",reuser);
        request.getSession().setAttribute("iconUrl",picService.getIconUrl(reuser));
        request.getSession().setAttribute("logininfo","login");
        return "redirect:/self_center_p/self";
    }
    @RequestMapping("/logout")
        public String Logout(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            request.getSession().invalidate();
            System.out.println("log out");
            request.getSession().setAttribute("logininfo","logout");
            return IndexController.index;
    }
    @RequestMapping("/update")
        public String update(User user,HttpServletRequest request,HttpServletRequest response){
                User operator = (User)request.getSession().getAttribute("user");
                user.getId();
                userService.updateUser(user);
                request.getSession().setAttribute("user",user);
                if(user.getId().equals(operator.getId()))
            return "redirect:/self_center_p/self";
        else
            return "redirect:/admin/rank_1.html";
        }
        @RequestMapping("/checking")
    @ResponseBody
    public String CheckUserEmail(@RequestParam("email")String email,HttpServletRequest request,HttpServletResponse response){
                boolean result = userService.hasUser(email);
                if(result==true){
                    System.out.print("用户名已存在");
                    return ajaxReturn(response,email,"邮箱已存在",1);
                }else{
                    return ajaxReturn(response,email,"合法的用户!",233);
                }
        }

}

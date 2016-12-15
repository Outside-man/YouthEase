package com.zlzkj.app.controller;

import com.zlzkj.core.util.UploadUtils;
import hziee.smvc.mapper.UserMapper;
import hziee.smvc.model.User;
import hziee.smvc.service.PicService;
import hziee.smvc.service.UserService;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class UserController {
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
        userService.NewUser(user);
        return "/"+IndexController.index;
    }
    @RequestMapping("/login")
    public String Login(User user,HttpServletRequest request,HttpServletResponse response){
        User reuser = userService.getUser(user.getEmail(),user.getPasswordHash());
     //   System.out.println(user.getPasswordHash());
        if(reuser==null)
            return "/"+IndexController.root+"/"+"register";
        request.getSession().setAttribute("user",reuser);
        request.getSession().setAttribute("iconUrl",picService.getIconUrl(reuser));
        return "/"+IndexController.index;
    }
    @RequestMapping("/logout")
        public String Logout(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
            request.getSession().invalidate();
            request.getSession().setAttribute("logininfo","logout");
            return IndexController.index;
    }
    @RequestMapping("/update")
        public String update(User user,HttpServletRequest request,HttpServletRequest response){
                System.out.println(user);
                userService.updateUser(user);
        return "redirect:/self_center_p/self";
        }

}

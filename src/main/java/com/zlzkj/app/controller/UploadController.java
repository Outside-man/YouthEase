package com.zlzkj.app.controller;

import hziee.smvc.model.User;
import hziee.smvc.service.PicService;
import hziee.smvc.service.ResourceService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
@RequestMapping("/uploads")
public class UploadController {
    @Autowired
    public ResourceService resourceService;
    @Autowired
    public PicService  picService;
    @RequestMapping("/userIcon")
    public String UploadIcon(@RequestParam("icon")MultipartFile file, HttpServletRequest request)
            throws IOException {
        User user =  (User)(request.getSession().getAttribute("user"));
        String filePath = resourceService.UploadFiles(file,request);
        request.getSession().setAttribute("iconUrl",picService.getIconUrl(user));
        System.out.println(filePath);
        return IndexController.JumpTo("self_center");
    }
}

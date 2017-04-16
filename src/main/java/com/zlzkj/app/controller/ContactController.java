package com.zlzkj.app.controller;

import com.zlzkj.core.base.BaseController;
import com.zlzkj.core.sql.Row;
import hziee.smvc.model.Contact;
import hziee.smvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
@Controller
public class ContactController extends BaseController {
    @Autowired
    private ContactService contactService;
    @RequestMapping("/contact")
    public String ContactUs(Contact contact, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Integer i=contactService.AddContact(contact);
        System.out.println("test");
        Map k = new Row();
        return IndexController.JumpTo("contact");
    }
}

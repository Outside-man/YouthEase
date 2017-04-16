package com.zlzkj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlzkj.core.base.BaseController;
import com.zlzkj.core.sql.Row;

/**
 * 首页控制器
 */
@Controller
public class IndexController extends BaseController{

	public static String index = "view/index";
	public static String root = "view";
	public static String adminRoot = "admin";
	@RequestMapping(value={"/"})
	public String index(Model model,HttpServletRequest request,HttpServletResponse response) {
		return IndexController.index;
	}
	public static String JumpTo(String s){
		return root+"/"+s;
	}
	public static String AdminJumpTo(String s){
		return adminRoot+"/"+s;
	}
}

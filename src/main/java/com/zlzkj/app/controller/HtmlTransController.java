package com.zlzkj.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlTransController {
	@RequestMapping("/*.html")
	public String trans(HttpServletRequest request,HttpServletResponse response){
		String s=request.getRequestURI();
		String part[]=s.split("[.|/]");
		String result=part[part.length-2];
		return "/"+IndexController.root+"/"+result;
	}
}

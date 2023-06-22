package com.app.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  //madatory to tell SC : following is req : controller=Handler,containing req handling methods
public class HomePageController {
	public HomePageController() {
		System.out.println("in constructor of "+getClass());
	}
	
	//add req handling method to forward the client to index.jsp
	@RequestMapping("/") //can intercept get/post/put/delete
	public ModelAndView showHomePage() {
		System.out.println("in show home page");
		//API o.s.w.s.ModelAndView(String lvn,String modelAttrName,object value)	
		return new ModelAndView("/index", "timestamp", LocalDateTime.now());
// M&V--Model & View , D.S--Dispatcher Servlet , LVN--Logical View Name , V.R--View Resolver 
//handler returns --> M&V --> D.S --> sends LVN --> V.R --> AVN : /WEB-INF/views/index.jsp --> D.S
		// checks for model attrs --> yes --> saves it under request scope
		// why --> server pull --> RD rd= request.getRD("/WEB-INF/views/index.jsp")
		// rd.forward(req,resp) --> JSP --> ${...}
	}

}

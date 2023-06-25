package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller 
public class HomepgaeController
{
public HomepgaeController()
{
	System.out.println("in constr of "+getClass());
}
//Add request handler method
@RequestMapping("/")//can intercept get/post/delete/put
public ModelAndView showHomePage()
{
	System.out.println("in show home page");
	return new ModelAndView("/index", "timestamp" , LocalDateTime.now());
}
}

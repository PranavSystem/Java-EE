package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	public HomePageController() {
		System.out.println();
	}
	
	@GetMapping("/")
	public String homePageShow() {
		return "You are in our home page"; 
	}
	
}

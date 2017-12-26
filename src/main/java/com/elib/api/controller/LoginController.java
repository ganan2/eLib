package com.elib.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String home() {
		return "login";
	}
	
	@RequestMapping("/")
	public String login() {
		return "redirect:/login";
	}

}

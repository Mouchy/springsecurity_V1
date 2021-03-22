package com.springsecurity.security.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationControllerWeb {

	@RequestMapping("/register")
	public String register() {
		System.out.println("La méthode signIn a été appelé");
		return "index";
	}
	
	
}

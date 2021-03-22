package com.springsecurity.security.core.api;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.security.core.entity.User;
import com.springsecurity.security.core.service.UserService;
import com.springsecurity.security.core.web.dto.UserRegistrationDto;

@RestController
@RequestMapping("/user")
public class UserResource {
	private UserService userService;

	public UserResource(UserService userService) {
		super();
		System.out.println("UserRegistrationController");
		this.userService = userService;
	}
	
	@GetMapping
	public String showRegistrationForm() {
		System.out.println("showRegistrationForm");
		return "registration";
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		System.out.println("UserRegistrationController UserRegistrationDto");
		return new UserRegistrationDto();
	}
	@PostMapping
	public User register(@PathParam("user") @RequestBody User user) {
		System.out.println("UserResource - UregisterUserAccount");
		
		return  userService.createUser(user);
	}
}

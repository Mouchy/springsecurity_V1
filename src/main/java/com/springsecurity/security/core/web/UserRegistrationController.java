package com.springsecurity.security.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.security.core.entity.User;
import com.springsecurity.security.core.service.UserService;

/*@Controller
@RequestMapping("/user")
public class UserRegistrationController {
	private UserService userService;

	public UserRegistrationController(UserService userService) {
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
	public User userRegistration() {
		System.out.println("UserRegistrationController UserRegistrationDto");
		return new User();	
	}
	@PostMapping
	public String createUser(@ModelAttribute("user") User user) {
		User userLocal = null;
		
		userLocal = userService.findByEmail(user.getEmail());
		
		if (userLocal == null) {
			userService.createUser(user);
		}
		else {
			System.out.println("registerUserAccount already exist");
		}
		return "redirect:/registration?success";
	}
}*/

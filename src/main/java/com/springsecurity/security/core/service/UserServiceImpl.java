package com.springsecurity.security.core.service;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.security.core.entity.Role;
import com.springsecurity.security.core.entity.User;
import com.springsecurity.security.core.exception.UserAlreadyExistsException;
import com.springsecurity.security.core.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		 System.out.println("UserServiceImpl");
	}

	@Override
	public User createUser(User user) throws UserAlreadyExistsException 	{
		User userAlreadyExist = findByEmail(user.getEmail());
		
		if (userAlreadyExist != null) { 
            throw new UserAlreadyExistsException("Username already exists");
        }
		
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
		
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}

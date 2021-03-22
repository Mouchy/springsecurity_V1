package com.springsecurity.security.core.service;

import com.springsecurity.security.core.entity.User;


public interface UserService {
    User createUser(User user);
    User findByEmail(String email);
}

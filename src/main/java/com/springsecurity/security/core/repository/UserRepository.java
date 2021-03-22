package com.springsecurity.security.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.security.core.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}

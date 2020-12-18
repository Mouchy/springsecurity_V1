package com.springsecurity.security.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    DataSource dataSource;
	@Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.jdbcAuthentication().dataSource(dataSource)
		.withDefaultSchema()
		.withUser("user")
        .password(encoder.encode("password"))
        .roles("USER");
    }
}

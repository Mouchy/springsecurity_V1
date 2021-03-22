package com.springsecurity.security.core.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
					.usersByUsernameQuery("select email, password, enabled from user where email = ?")
					.authoritiesByUsernameQuery("select email, authority from authorities where email = ?");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests((authorize) -> authorize
					.antMatchers("/user", "/user/**", "/controller/**", "/index").permitAll()
					//.antMatchers("/user/**").hasRole("USER")
					.anyRequest().denyAll() 
				)
				/*.authorizeRequests()
					.antMatchers("/api/**", "/controller/**", "/index").permitAll()
					.and()*/
				.formLogin((formLogin) -> formLogin
					.loginPage("/login")
					.failureUrl("/login-error")
				);
	}
	
}

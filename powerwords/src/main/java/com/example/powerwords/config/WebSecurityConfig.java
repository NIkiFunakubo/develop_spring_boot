package com.example.powerwords.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.powerwords.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/signup","/login","/login-error").permitAll()
				.antMatchers("/**").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login").failureUrl("/login-error");
		http
			.logout().logoutSuccessUrl("/login").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
		//userService.registerAdmin("funakuboniki", "testconnectiondesu", "funakuboniki.niki@Gmail.com");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}

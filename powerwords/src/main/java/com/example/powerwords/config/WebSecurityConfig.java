package com.example.powerwords.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.powerwords.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void configure(WebSecurity web)throws Exception {
		web.ignoring().antMatchers("/css/**","/images/**","/js/**");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
		http.authorizeRequests()
				.antMatchers("/","/login","/login-error").permitAll()
				.antMatchers("/signup").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/login-error").permitAll()
				.antMatchers("/**").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
		http
			.csrf().disable()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error")
				.defaultSuccessUrl("/", true)
				.usernameParameter("username")
				.passwordParameter("password");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
		//userService.registerAdmin("funakuboniki", "testconnectiondesu", "funakuboniki.niki@Gmail.com");
	}
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	      authenticationProvider.setUserDetailsService(userService);
	      authenticationProvider.setPasswordEncoder(passwordEncoder());
	      return authenticationProvider;
	 }
	

	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	*/
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}

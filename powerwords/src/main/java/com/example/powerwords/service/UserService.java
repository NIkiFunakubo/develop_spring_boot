package com.example.powerwords.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.powerwords.dao.UsersDao;
import com.example.powerwords.entity.UserAccount;
import com.example.powerwords.entity.Users;

@Service
public class UserService implements UserDetailsService{
	
	
	@Autowired(required=true)
	private UsersDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		if(username == null || "".equals(username)) {
			throw new UsernameNotFoundException("Username is Empty");
		}
		
		Users usr = dao.findByUsername(username);
		if(usr == null ) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		if(!usr.isEnabled()) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		
		UserAccount user = new UserAccount(usr,getAuthorities(usr));
		
		return user;
	}
	
	private Collection<GrantedAuthority> getAuthorities(Users user){
		
		if(user.isAdmin()){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER");
		}else{
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
		
	}
	
	
	@Transactional
	public void registerAdmin(String username, String password, String email) {
		Users user = new Users(username,passwordEncoder.encode(password),email,true);
		user.setAdmin(true);
		dao.insert(user);
	}
	
	@Transactional
	public void registerUser(String username,String password,String email) {
		Users user = new Users(username,passwordEncoder.encode(password),email,false);
		dao.insert(user);
	}
	
}

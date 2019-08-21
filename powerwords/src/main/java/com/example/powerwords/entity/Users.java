package com.example.powerwords.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class Users {
	
	protected Users() {}
	
	public Users(String username,String password,String email,boolean isAdmin) {
		setUserId(0L);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setEnabled(true);
		setAdmin(isAdmin);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="user_name")
	private String username;
	
	private String password;
	private String email;
	/*
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	*/	
	private boolean enabled;
	private boolean admin;
	/*
	@Version
	private int version;
	*/
	
	/*
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
	*/
	
}

package com.example.powerwords.form;

import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
@Setter
public class LoginForm {
	
	@NotEmpty
	@Pattern(regexp="^\\w{3,32}$", message="size must be between 3 and 32, each character must be alphanumeric or underscore (A-Za-z0-9_)")
	private String username;
	
	@NotEmpty
	@Size(min=8, max=255)
	private String password;
	
}

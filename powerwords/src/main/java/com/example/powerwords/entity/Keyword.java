package com.example.powerwords.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/



@Entity
@Table(name="keyword")
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String userName;
	
	private String keyword;
	
	private String description;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

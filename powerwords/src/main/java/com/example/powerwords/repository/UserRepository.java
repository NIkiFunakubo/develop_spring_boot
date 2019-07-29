package com.example.powerwords.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.powerwords.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	public User findByUsername(String username);
	
	public User findByMailAddress(String mailAddress);	

}

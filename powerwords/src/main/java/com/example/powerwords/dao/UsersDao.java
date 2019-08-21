package com.example.powerwords.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import com.example.powerwords.entity.Users;

@ConfigAutowireable
@Dao
public interface UsersDao {
	
	@Select
	List<Users> selectAll();
	
	@Select
	Users findByUsername(String username);
	
	@Insert
	@Transactional
	int insert(Users user);

}

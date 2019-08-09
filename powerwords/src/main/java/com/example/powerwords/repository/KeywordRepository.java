package com.example.powerwords.repository;

import java.util.List;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.powerwords.entity.Keyword;

@ConfigAutowireable
@Dao
public interface KeywordRepository {
	
	@Select
	List<Keyword> findall();
	
	@Select
	Optional<Keyword> findById(Integer id);
	
}

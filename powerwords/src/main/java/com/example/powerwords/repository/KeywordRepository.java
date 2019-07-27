package com.example.powerwords.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.powerwords.entity.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Integer>{
	public Optional<Keyword> findById(Integer name);

}

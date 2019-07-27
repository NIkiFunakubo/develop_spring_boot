package com.example.powerwords.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.powerwords.entity.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Integer>{

}

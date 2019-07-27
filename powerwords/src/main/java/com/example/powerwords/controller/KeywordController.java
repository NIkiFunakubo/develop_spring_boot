package com.example.powerwords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.powerwords.entity.Keyword;
import com.example.powerwords.repository.KeywordRepository;

@Controller
@RequestMapping(path = "/demo")
public class KeywordController {

	@Autowired
	private KeywordRepository repository;

	@GetMapping(path = "/add")
	@ResponseBody
	public String addNewKeyword(@RequestParam String username, @RequestParam String keyword) {

		Keyword k = new Keyword();
		k.setUserName(username);
		k.setKeyword(keyword);
		repository.save(k);
		return "saved";
	}

	@GetMapping(path = "/all")
	@ResponseBody
	public Iterable<Keyword> getAllKeywords() {
		return repository.findAll();
	}

}

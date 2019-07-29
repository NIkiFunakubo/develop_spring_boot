package com.example.powerwords.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.powerwords.entity.Keyword;
import com.example.powerwords.repository.KeywordRepository;

@Controller
public class KeywordController {

	@Autowired
	private KeywordRepository repository;

	@GetMapping(path = "/")
	public ModelAndView index(@ModelAttribute("formModel") Keyword keyword, ModelAndView mav) {
		mav.setViewName("index");
		Iterable<Keyword> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}


	@PostMapping(path = "/")
	@Transactional(readOnly = false)
	public ModelAndView form(@ModelAttribute("formModel") Keyword keyword, ModelAndView mav) {
		repository.saveAndFlush(keyword);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping(path="/edit/{id}")
	public ModelAndView edit(@ModelAttribute Keyword keyword,@PathVariable int id,ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title","edit mydata");
		Optional<Keyword> data = repository.findById(id);
		mav.addObject("formModel",data.get());
		return mav;
	}

	@PostMapping(path="/edit")
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute("formModel") Keyword keyword,ModelAndView mav) {
		repository.saveAndFlush(keyword);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping(path="/delete/{id}")
	public ModelAndView delete(@PathVariable int id,ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title","delete mydata.");
		Optional<Keyword> data = repository.findById(id);
		mav.addObject("formModel",data.get());
		return mav;
	}
	
	@PostMapping(path="/delete")
	@Transactional(readOnly=false)
	public ModelAndView remove(@RequestParam int id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}

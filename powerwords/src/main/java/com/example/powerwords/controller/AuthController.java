package com.example.powerwords.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.powerwords.entity.Keyword;
import com.example.powerwords.form.SignupForm;
import com.example.powerwords.repository.KeywordRepository;
import com.example.powerwords.service.UserService;

@Controller
public class AuthController {

	@Autowired
	UserService userService;

/*	
    @RequestMapping("/")
    public String index() {
        return "redirect:/messages";
    }
*/
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {
        return "redirect:/login-error";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(Model model, @Valid SignupForm signupForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            userService.registerUser(signupForm.getUsername(), signupForm.getPassword(), signupForm.getEmail());
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("signupError", true);
            return "signup";
        }

        try {
            request.login(signupForm.getUsername(), signupForm.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}

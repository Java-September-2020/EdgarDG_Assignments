package com.edgar.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edgar.login.models.User;
import com.edgar.login.services.UserService;
import com.edgar.login.validations.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String landing(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			//If validation errors send them back to Login Page
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttrs) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "dashboard.jsp";
	}
	
	@GetMapping("/dashboard")
	public String index(HttpSession session, Model viewModel) {
		if(session.getAttribute("owner_id") == null) {
			return "redirect:/";
		}
		//Long userId = (Long)session.getAttribute("user_id");
		//User user = this.uService.getOneUser(userId);
		return "dashboard.jsp";
	}
	
	
	//LogOut
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}

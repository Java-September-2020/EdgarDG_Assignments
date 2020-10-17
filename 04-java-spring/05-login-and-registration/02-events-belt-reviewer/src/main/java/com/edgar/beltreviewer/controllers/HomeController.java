package com.edgar.beltreviewer.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edgar.beltreviewer.models.Event;
import com.edgar.beltreviewer.models.User;
import com.edgar.beltreviewer.services.EventService;
import com.edgar.beltreviewer.services.UserService;
import com.edgar.beltreviewer.validators.UserValidator;


@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private EventService eService;
	
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
	public String login(@ModelAttribute("event") Event event, HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttrs, Model viewModel) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		Long userId = user.getId();
		String userState = user.getState();
		viewModel.addAttribute("inState", this.eService.findEventsByState(userState));
		viewModel.addAttribute("notInState", this.eService.findEventsByNotState(userState));
		viewModel.addAttribute("user_id", userId);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String index(@ModelAttribute("event") Event event, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		User user = this.uService.getOneUser(userId);
		String userState = user.getState();
		viewModel.addAttribute("inState", this.eService.findEventsByState(userState));
		viewModel.addAttribute("notInState", this.eService.findEventsByNotState(userState));
		viewModel.addAttribute("user_id", userId);
		return "dashboard.jsp";
	}
	
	
	@PostMapping("/events/new")
	public String newEvent(@Valid @ModelAttribute("event") Event newEvent, BindingResult result, Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "edit.jsp";
		}
		eService.saveEvent(newEvent);
		return "redirect:/dashboard";
	}

	@GetMapping("/events/{id}/edit")
	public String viewEditEvent(@ModelAttribute("event") Event event, @PathVariable("id") Long id, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		if(!eService.findHostId(id).equals(session.getAttribute("user_id"))) {
			return "redirect:/dashboard";
		}
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("event", this.eService.findOneEvent(id));
		return "edit.jsp";
	}

	@PostMapping("/events/{id}/edit")
	public String editEvent(@Valid @ModelAttribute("event") Event updatedEvent, BindingResult result, Model viewModel, HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "edit.jsp";
		}
		this.eService.saveEvent(updatedEvent);
		return "redirect:/dashboard";
	}

	
	
	
	//LogOut
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}

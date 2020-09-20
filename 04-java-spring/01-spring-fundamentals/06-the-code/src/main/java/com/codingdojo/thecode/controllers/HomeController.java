package com.codingdojo.thecode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(@ModelAttribute("errors") String errors) {
        return "index.jsp";
    }
    @RequestMapping("/errors")
    public String errors(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("errors", "You must train harder!");
        return "redirect:/";
    }
    @RequestMapping("/code")
    public String code(HttpSession session, @RequestParam(value="password") String password) {
    	if (password.equals("bushido")) {
        	return "code.jsp";
    	} else {
    		return "redirect:/errors";
    	}

    }
    
}

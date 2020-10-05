package com.edgar.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.relationships.models.Dojo;
import com.edgar.relationships.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private DojoService dService;
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/new")
	public String newDojoInput(@Valid @ModelAttribute("dojo") Dojo newDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			this.dService.createDojo(newDojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/{id}")
	public String showDojo(@PathVariable("id") Long id, Model dModel) {
		System.out.println(this.dService.getOneDojo(id));
		dModel.addAttribute("dojo", this.dService.getOneDojo(id));
		return "showDojo.jsp";
	}
	
}

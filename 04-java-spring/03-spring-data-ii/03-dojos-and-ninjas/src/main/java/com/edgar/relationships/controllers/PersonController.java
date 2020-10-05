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

import com.edgar.relationships.models.Person;
import com.edgar.relationships.services.LicenseService;
import com.edgar.relationships.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
		
	@GetMapping("/new")
	public String newPersonPage(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/new")
	public String newPerson(@Valid @ModelAttribute("person") Person newPerson, BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			this.pService.createPerson(newPerson);
			return "redirect:/persons/new";
		}

	}
	
	@RequestMapping("/{id}")
	public String showPerson(@PathVariable("id") Long id, Model personModel, Model licenseModel) {
		personModel.addAttribute("person", this.pService.getOnePerson(id));
		licenseModel.addAttribute("license", this.lService.getOneLicense(id));
		return "showPerson.jsp";
	}
	
	
	
	
}

package com.edgar.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.relationships.models.License;
import com.edgar.relationships.services.LicenseService;
import com.edgar.relationships.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	
	@Autowired
	private LicenseService lService;
	@Autowired
	private PersonService pService;

	@GetMapping("/new")
	public String newLicenseShow(@ModelAttribute("license") License license, Model personModel) {
		personModel.addAttribute("person", this.pService.getAllPersons());
		return "newLicense.jsp";
	}
	
	@PostMapping("/new")
	public String newLicense(@Valid @ModelAttribute("license") License newLicense, BindingResult result, Model personModel) {
		if (result.hasErrors()) {
			personModel.addAttribute("person", this.pService.getAllPersons());
			return "newLicense.jsp";
		} else {
			this.lService.createNewLicense(newLicense);
			return "redirect:/licenses/new";
		}
	}
}

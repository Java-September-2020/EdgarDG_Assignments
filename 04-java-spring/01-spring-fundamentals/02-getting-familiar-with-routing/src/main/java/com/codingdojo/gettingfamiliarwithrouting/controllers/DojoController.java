package com.codingdojo.gettingfamiliarwithrouting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DojoController {
	@RequestMapping(value="/dojo", method=RequestMethod.GET)
	public String showDojo() {
		return "dojo.jsp";
	}
	@RequestMapping(value="/dojo/{city}", method=RequestMethod.GET)
	public String showCity(@PathVariable("city") String locationName, Model model) {
		model.addAttribute("locationName", locationName);
		return "dojocity.jsp";
	}
	@RequestMapping("/dojo/san-jose")
	public String hqPage() {
		return "sjdojo.jsp";
	}
}

package com.edgar.languages.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edgar.languages.models.Language;
import com.edgar.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService lService;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")	
	public String index(Model viewModel, @ModelAttribute("language") Language language) {
		List<Language> allLangs = this.lService.getAllLanguages();
		viewModel.addAttribute("allLangs", allLangs);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createNew(@Valid @ModelAttribute("language") Language newLanguage, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Language> allLangs = this.lService.getAllLanguages();
			viewModel.addAttribute("allLangs", allLangs);
			return "index.jsp";
		} else {
		this.lService.createLanguage(newLanguage);
		return "redirect:/languages";
		}
	}

    @RequestMapping("/errors")
    public String errors(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("errors", "A test errror!");
        return "redirect:/";
    }
	
	@RequestMapping("/languages/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("language", this.lService.getOneLanguage(id));
		return "edit.jsp";
	}
	
	@RequestMapping("/languages/{id}")
	public String viewLang(@ModelAttribute("language") Language language, @PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("language", this.lService.getOneLanguage(id));
		return "show.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("language") Language updatedLanguage, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.lService.updateLanguage(updatedLanguage);
			return "redirect:/languages";			
		}

	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/languages";			
		}

	
}

package com.edgar.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.dojooverflow.models.Answer;
import com.edgar.dojooverflow.models.Question;
import com.edgar.dojooverflow.services.AnswerService;
import com.edgar.dojooverflow.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class HomeController {
	@Autowired
	private AnswerService aService;
	@Autowired
	private QuestionService qService;

	// Dashboard View
	@RequestMapping("")
	public String dashbaord(Model viewModel) {
		viewModel.addAttribute("question", this.qService.getAllQuestions());
		return "dashboard.jsp";
	}

	// Dashboard Redirect with New Question
	@PostMapping("")
	public String newQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			this.qService.newQuestionLogic(question);
			return "redirect:/questions";
		}
	}

	// New Question
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}

	// View Question
	@RequestMapping("/{id}")
	public String viewQuestion(@ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, Model viewModel) {
		return "viewQuestion.jsp";
	}

	// Add Answer to Question
	@PostMapping("/{id}")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result,
			@PathVariable("id") Long id, Model viewModel) {
		if (result.hasErrors()) {
			return "viewQuestion.jsp";
		} else {
			this.aService.createAnswer(answer);
			return "redirect:/questions";
		}
	}

}

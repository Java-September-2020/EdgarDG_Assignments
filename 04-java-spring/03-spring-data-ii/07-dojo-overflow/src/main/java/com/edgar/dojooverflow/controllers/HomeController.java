package com.edgar.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edgar.dojooverflow.models.Question;
import com.edgar.dojooverflow.models.Tag;
//import com.edgar.dojooverflow.services.AnswerService;
import com.edgar.dojooverflow.services.QuestionService;
import com.edgar.dojooverflow.services.TagService;

/**
 * @author Edgar
 *
 */
@Controller
@RequestMapping("/questions")
public class HomeController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private TagService tService;
//	@Autowired
//	private AnswerService aService;

	// Dashboard
	@RequestMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}

	// Show New Page
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question newQuestion) {
		return "newQuestion.jsp";
	}

	// New Page Logic
	@PostMapping("/new")
	public String newQuestionLogic(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		System.out.println(question.getTags());
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			//Create Question
			//change to root route later
			return "redirect:/questions/new";
		}
	}

	
	// Show Question
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long id) {
		return "questionProfile.jsp";
	}

	// Add Answer
	@PostMapping("/{id}")
	public String addAnswer(@PathVariable("id") Long id) {
		return "redirect:/{id}";
	}

	
	
	
	
//	//Get all Tags
//	List<Tag> allTags = this.tService.findAllTags();
//	//Create New Question
//	newQuestion.setQuestion(question);
//	Question quest = this.qService.createQuestion(newQuestion);
//	//Make List of Question Tags
//	List<Tag> questionTags = newQuestion.getTags();
//	
//	//Add tags into Question List
//	String[] tagArray = tags.split("//s*,//s*");
//	for(String tag : tagArray) {
//		Tag newTag = this.tService.findByName(tag);
//		if(tag == null) {
//			newTag = new Tag(tag);
//			this.tService.createTag(newTag);
//		}
//		//Duplicate Protection
//		if(!allTags.contains(newTag)) {
//			questionTags.add(newTag);
//		}
//	}
//	System.out.println(quest.getQuestion() + " " + quest.getTags());
	
	
	
	
	
	
	
	/*
	 * @PostMapping("/new") public String newQuestionLogic(@RequestParam("question")
	 * String question, @RequestParam("tag") String tag, RedirectAttributes
	 * redirectAttr) { System.out.println(question + tag); ArrayList<String> errors
	 * = new ArrayList<String>(); //Split Tag by , String[] tagArray =
	 * tag.split(",");
	 * 
	 * if(question.trim().equals("")) { errors.add("Question must not be blank"); }
	 * if(tag.trim().equals("")) { errors.add("Please add a tag to the Question"); }
	 * if(tag.contains(" ") && !tag.contains(",")) {
	 * errors.add("Tags must be separated by commas"); } if(tag.toLowerCase() !=
	 * tag) { errors.add("Tags must be lowercase"); } //3 Tag Max Validation
	 * if(tagArray.length > 3) { errors.add("Cannot have more than Three tags"); }
	 * if(errors.size() > 0) { for(String e: errors) {
	 * redirectAttr.addFlashAttribute("errors", e); } } else {
	 * 
	 * //Place into List List<String> tagList = Arrays.asList(tagArray);
	 * System.out.println(tagList.size());
	 * 
	 * //Place into ArrayList ArrayList<String> tagArrayList = new
	 * ArrayList<String>(tagList);
	 * 
	 * //Use .get(i) to get elements from ArrayList
	 * 
	 * 
	 * //Create Question
	 * 
	 * //Add Question and Tag into Questions_Tags
	 * 
	 * }
	 * 
	 * 
	 * return "redirect:/questions/new"; }
	 */	
	
}

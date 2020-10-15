package com.edgar.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Question;
import com.edgar.dojooverflow.models.Tag;
import com.edgar.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;

	// Create a Question
	public Question createQuestion(Question newQuestion) {
		Question question = this.qRepo.save(newQuestion);
		return question;
	}
	
	// Create a Question Overload
	public Question createQuestion(String question, List<Tag> tags) {
		Question newQuestion = new Question(question, tags);
		return newQuestion;
	}

	// Add Tag to Question
	public void addTagtoQuestion(Question question, Tag tag) {
		// Get List of Tags from Question object
		List<Tag> taggedQuestions = question.getTags();
		// Append Tag to List of Tags inside Question object
		taggedQuestions.add(tag);
		// Save Question object that now has Appended Tag List
		this.qRepo.save(question);
	}

}

package com.edgar.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Question;
import com.edgar.dojooverflow.models.Tag;
import com.edgar.dojooverflow.repositories.QuestionRepository;
import com.edgar.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tRepo;
	@Autowired
	private TagService tService;

	public Question createQuestion(Question newQuestion) {
		Question question = this.qRepo.save(newQuestion);
		return question;
	}

	public List<Question> getAllQuestions() {
		List<Question> question = this.qRepo.findAll();
		return question;
	}

	public Question getOneQuestion(Long id) {
		Question question = this.qRepo.findById(id).orElse(null);
		return question;
	}

	public Question newQuestionLogic(Question question) {
		// Create Empty Array List to populate later
		ArrayList<Tag> questionTags = new ArrayList<Tag>();
		// Takes TagString List from Model and splits by comma
		String[] arrayTag = question.splitTags();

		// iterate through arrayTag to add to List<Tag>
		for (String tag : arrayTag) {
			// Finds if tag is unique
			Tag newTag = this.tRepo.findByTag(tag).orElse(null);
			// If Tag unique(null) creates new Tag
			if (tag == null) {
				newTag = new Tag();
				newTag.setTag(tag);
				this.tService.createTag(newTag);
			}
			if (!questionTags.contains(newTag)) {
				questionTags.add(newTag);
			}
		}

		// Add List of Tags from above, Create Question with all the logic applied
		question.setTags(questionTags);
		Question newQuestionWithLogic = this.newQuestionLogic(question);
		return newQuestionWithLogic;

	}
}

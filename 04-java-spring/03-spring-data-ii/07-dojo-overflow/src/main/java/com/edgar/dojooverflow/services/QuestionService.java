package com.edgar.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Question;
import com.edgar.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;


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
	
}

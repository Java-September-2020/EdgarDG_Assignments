package com.edgar.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Answer;
import com.edgar.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;

	// Find All Answers
	public List<Answer> findAllAnswers() {
		List<Answer> allAnswers = this.aRepo.findAll();
		return allAnswers;
	}

	// Create Answer
	public Answer createAnswer(Answer newAnswer) {
		Answer answer = this.aRepo.save(newAnswer);
		return answer;
	}

}

package com.edgar.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgar.dojooverflow.models.Answer;
import com.edgar.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByQuestion(Question question);
}

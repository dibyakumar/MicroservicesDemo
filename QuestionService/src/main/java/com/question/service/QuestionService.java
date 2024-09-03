package com.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qrepo;
	
	public Question add(Question question) {
		return qrepo.save(question);
	}
	
	public List<Question> getAll(){
		return qrepo.findAll();
	}
	
	public Question get(Long id) {
		return qrepo.findById(id).orElseThrow(()-> new RuntimeException("No Question found"));
	}

	public List<Question> getByQuiz(Long id) {
		return qrepo.findByQuizId(id);
	}
}

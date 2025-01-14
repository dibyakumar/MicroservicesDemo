package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService qservice;
	
	@PostMapping("/add")
	public Quiz create(@RequestBody Quiz quiz) {
		return qservice.add(quiz);
	}
	
	@GetMapping("getAll")
	private List<Quiz> getAll(){
		return qservice.get();
	}
	
	@GetMapping("/get/{id}")
	private Quiz get(@PathVariable("id") Long id) {
		return qservice.get(id);
	}
	
	
}

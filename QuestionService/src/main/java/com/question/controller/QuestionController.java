package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService qservice;
	

	
	
	@PostMapping("/add")
	public Question create(@RequestBody Question question) {
		return qservice.add(question);
	}
	
	@GetMapping("getAll")
	private List<Question> getAll(){
		return qservice.getAll();
	}
	
	@GetMapping("/get/{id}")
	private Question get(@PathVariable("id") Long id) {
		return qservice.get(id);
	}
	
	@GetMapping("/getQuestionOfQuiz/{id}")
	private List<Question> getQuestionByQuiz(@PathVariable Long id){
		return qservice.getByQuiz(id);
	}
	
}

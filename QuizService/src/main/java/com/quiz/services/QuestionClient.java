package com.quiz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entity.Questions;

//@FeignClient(url = "http://localhost:8082",value="Question-Client")
//for load balancing 
@FeignClient(name="QUESTIONSERVICE")
public interface QuestionClient {
	@GetMapping("/question/getQuestionOfQuiz/{id}")
	List<Questions> getQuestions(@PathVariable("id") Long id); 	
}

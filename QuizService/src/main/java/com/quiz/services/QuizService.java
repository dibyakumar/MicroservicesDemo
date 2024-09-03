package com.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	public Quiz add(Quiz q) {
		return quizRepository.save(q);
	}
	
	public List<Quiz> get(){
		List<Quiz> allQuizes = quizRepository.findAll();
		List<Quiz> quizesWithQuestion = allQuizes.stream().map(q->{
			q.setQuestions(questionClient.getQuestions(q.getId()));
			return q;
		}
				).collect(Collectors.toList());
	
	return quizesWithQuestion;
	}
	
	public Quiz get(Long id) {
		 Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("No Quiz Found with the id provided !!"));
		 quiz.setQuestions(questionClient.getQuestions(id));
		 return quiz;
	}
	
		
	}



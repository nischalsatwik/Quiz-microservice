package com.satwik.quiz_service.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satwik.quiz_service.Feign.Quizinterface;
import com.satwik.quiz_service.Model.Question;
import com.satwik.quiz_service.Model.QuestionWrapper;
import com.satwik.quiz_service.Model.Quiz;
import com.satwik.quiz_service.Model.Responsecheck;
import com.satwik.quiz_service.Repo.Quizrepo;

import java.util.*;
@Service

public class Quizservice {

	@Autowired
	private Quizrepo repo;
	@Autowired
	private Quizinterface quizinterface;
	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
        List<Integer> questions =quizinterface.getQuestionsForQuiz(category, numq).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        repo.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	public ResponseEntity<List<QuestionWrapper>> getquestions(Integer id) {
		Quiz quiz=repo.findById(id).get();
		List<Integer> questionids=quiz.getQuestions();
		ResponseEntity<List<QuestionWrapper>> questions =quizinterface.getquestionsfromid(questionids);
		return questions;
	}
	public ResponseEntity<Integer> calculate(Integer id, List<Responsecheck> responses) {
		ResponseEntity<Integer> score=quizinterface.getscore(responses);
		return score;
	}

}

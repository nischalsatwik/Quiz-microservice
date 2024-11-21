package com.satwik.quiz_service.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satwik.quiz_service.Model.Question;
import com.satwik.quiz_service.Model.QuestionWrapper;
import com.satwik.quiz_service.Model.Quizdto;
import com.satwik.quiz_service.Model.Responsecheck;
import com.satwik.quiz_service.Service.Quizservice;

import java.util.*;
@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private Quizservice service;
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody Quizdto quizdto)
	{
		return service.createQuiz(quizdto.getCategoryName(),quizdto.getNumQuestions(),quizdto.getTitle());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getquestions(@PathVariable Integer id)
	{
		return service.getquestions(id);
	}
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitquiz(@PathVariable Integer id,@RequestBody List<Responsecheck> responses)
	{
		return service.calculate(id,responses);
	}
	
}

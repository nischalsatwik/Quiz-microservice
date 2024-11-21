package com.satwik.Questionservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

import com.satwik.Questionservice.Model.Question;
import com.satwik.Questionservice.Model.QuestionWrapper;
import com.satwik.Questionservice.Service.Questionservice;
import com.satwik.Questionservice.Model.Responsecheck;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private Questionservice service;
	@GetMapping("/greet")
	public String hello()
	{
		return "hello questionservice";
	}
    @GetMapping("/allquestions")
    public List<Question> getallquestions()
    {
    	return service.getallquestions();
    }
    @GetMapping("/category/{category}")
    public List<Question> getcategory(@PathVariable String category)
    {
    	return service.getcategory(category);
    }
    @PostMapping("/add")
    public String addquestion(@RequestBody Question question)
    {
    	return service.addquestion(question);
    }
    @GetMapping("/generatequestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryname, @RequestParam Integer numQuestions)
    {
    	return service.getQuestionsforQuiz(categoryname, numQuestions);
    }
    @PostMapping("/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getquestionsfromid(@RequestBody List<Integer> questionids)
    {
    	return service.getquestionsfromid(questionids);
    }
    @PostMapping("/getscore")
	public ResponseEntity<Integer> getscore(@RequestBody List<Responsecheck> responses)
	{
		return service.getscore(responses);
	}
}


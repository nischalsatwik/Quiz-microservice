package com.satwik.Quiz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.satwik.Quiz.Model.Question;
import com.satwik.Quiz.Service.Questionservice;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private Questionservice service;
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
}

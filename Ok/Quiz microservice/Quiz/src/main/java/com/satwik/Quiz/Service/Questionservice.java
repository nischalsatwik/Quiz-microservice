package com.satwik.Quiz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.satwik.Quiz.Model.Question;
import com.satwik.Quiz.Repo.QuestionRepo;

@Service
public class Questionservice {
	@Autowired
	private QuestionRepo repo;
	public List<Question> getallquestions() {
		return repo.findAll();
	}
	public List<Question> getcategory(String category) {
		// TODO Auto-generated method stub
		return repo.findByCategory(category);
	}
	public String addquestion(Question question) {
		// TODO Auto-generated method stub
		repo.save(question);
		return "success";
	}
	

}

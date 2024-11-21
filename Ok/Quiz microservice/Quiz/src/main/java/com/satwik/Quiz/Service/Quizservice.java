package com.satwik.Quiz.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satwik.Quiz.Model.Question;
import com.satwik.Quiz.Model.QuestionWrapper;
import com.satwik.Quiz.Model.Quiz;
import com.satwik.Quiz.Model.Responsecheck;
import com.satwik.Quiz.Repo.QuestionRepo;
import com.satwik.Quiz.Repo.Quizrepo;

import java.util.*;
@Service

public class Quizservice {

	@Autowired
	private Quizrepo repo;
	@Autowired
	private QuestionRepo repo1;
	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		List<Question> questions = repo1.findRandomQuestionsByCategory(category,numq);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		repo.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	public ResponseEntity<List<QuestionWrapper>> getquestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz=repo.findById(id);
		List<Question> questionsfromdb=quiz.get().getQuestions();
		List<QuestionWrapper> questionsforuser=new ArrayList<>();
		for(Question q: questionsfromdb) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsforuser.add(qw);
		}
		return new ResponseEntity<>(questionsforuser,HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculate(Integer id, List<Responsecheck> responses) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz=repo.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		int i=0;
		int right=0;
		for(Responsecheck response: responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
			{
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	

}

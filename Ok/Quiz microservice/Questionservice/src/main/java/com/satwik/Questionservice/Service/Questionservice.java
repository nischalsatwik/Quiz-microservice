package com.satwik.Questionservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

import com.satwik.Questionservice.Model.Question;
import com.satwik.Questionservice.Model.QuestionWrapper;
import com.satwik.Questionservice.Repo.QuestionRepo;
import com.satwik.Questionservice.Model.Responsecheck;

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
	public ResponseEntity<List<Integer>> getQuestionsforQuiz(String categoryname, Integer numQuestions) {
		// TODO Auto-generated method stub
		List<Integer> questions = repo.findRandomQuestionsByCategory(categoryname,numQuestions);
		return new ResponseEntity <>(questions,HttpStatus.OK);
	}
	public ResponseEntity<List<QuestionWrapper>> getquestionsfromid(List<Integer> questionids) {
		// TODO Auto-generated method stub
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<Question> questions =new ArrayList<>();
		for(Integer id: questionids)
		{
			questions.add(repo.findById(id).get());
		}
		for(Question question:questions)
		{
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}
	public ResponseEntity<Integer> getscore(List<Responsecheck> responses) {
		// TODO Auto-generated method stub
		
		int right=0;
		for(Responsecheck response: responses)
		{
			Question question =repo.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer()))
			{
				right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}

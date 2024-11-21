package com.satwik.quiz_service.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.satwik.quiz_service.Model.QuestionWrapper;
import com.satwik.quiz_service.Model.Responsecheck;

@FeignClient("QUESTIONSERVICE")
public interface Quizinterface {
	@GetMapping("/question/generatequestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryname, @RequestParam Integer numQuestions);
   
    @PostMapping("question/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getquestionsfromid(@RequestBody List<Integer> questionids);
    
    @PostMapping("/question/getscore")
	public ResponseEntity<Integer> getscore(@RequestBody List<Responsecheck> responses);
}

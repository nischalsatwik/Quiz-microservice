package com.satwik.Quiz.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.satwik.Quiz.Model.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM Question q where q.category=:category ORDER BY RAND() LIMIT :numq",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numq);
}
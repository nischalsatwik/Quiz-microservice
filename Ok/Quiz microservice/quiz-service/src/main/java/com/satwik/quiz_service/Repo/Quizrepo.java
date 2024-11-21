package com.satwik.quiz_service.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satwik.quiz_service.Model.Quiz;

@Repository
public interface Quizrepo extends JpaRepository<Quiz,Integer> {

}

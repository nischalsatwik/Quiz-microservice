package com.satwik.Quiz.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.satwik.Quiz.Model.Quiz;

@Repository
public interface Quizrepo extends JpaRepository<Quiz,Integer> {

}

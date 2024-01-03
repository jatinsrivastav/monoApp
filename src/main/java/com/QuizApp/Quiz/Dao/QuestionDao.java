package com.QuizApp.Quiz.Dao;

import com.QuizApp.Quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


     public List<Question> findByCategory(String category);

     @Query( value = "SELECT * from questions q where q.category= :category ORDER BY rand() LIMIT :numQ" ,nativeQuery = true)
     public List<Question> findRandomQuestionByCatgeory(String category, int numQ);
}

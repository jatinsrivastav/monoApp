package com.QuizApp.Quiz.Dao;

import com.QuizApp.Quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository <Quiz,Integer> {
}

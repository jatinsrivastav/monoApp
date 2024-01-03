package com.QuizApp.Quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
/* using Data to avoid creating setter and getter*/
@Entity(name = "questions")  //table name is different in the database.
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id; // I have to put auto increment condition in the MySql cause it was not incrementing by itself
   private String category;
   private String option1;
   private String option2;
   private String rightanswer;
   private String title;
}


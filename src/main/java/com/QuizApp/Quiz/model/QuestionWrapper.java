package com.QuizApp.Quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id; // I have to put auto increment condition in the MySql cause it was not incrementing by itself
    private String category;
    private String option1;
    private String option2;
    private String title;

    public QuestionWrapper(Integer id, String category, String option1, String option2, String title) {
        this.id = id;
        this.category = category;
        this.option1 = option1;
        this.option2 = option2;
        this.title = title;
    }
}


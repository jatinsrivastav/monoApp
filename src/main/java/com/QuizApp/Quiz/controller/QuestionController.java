package com.QuizApp.Quiz.controller;

import com.QuizApp.Quiz.Service.QuestionService;
import com.QuizApp.Quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public List<Question> getallQuestion(){
        return questionService.getAllQuestion();
    }
}

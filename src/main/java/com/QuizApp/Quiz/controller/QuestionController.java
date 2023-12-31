package com.QuizApp.Quiz.controller;

import com.QuizApp.Quiz.Service.QuestionService;
import com.QuizApp.Quiz.model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>>getallQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/question/{category}")
    public  ResponseEntity<List<Question>> getquestionbyCategory(@PathVariable("category") String category){
        return questionService.getQuestion(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }
}

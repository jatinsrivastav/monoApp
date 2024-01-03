package com.QuizApp.Quiz.controller;

import com.QuizApp.Quiz.Service.QuizService;
import com.QuizApp.Quiz.model.QuestionWrapper;
import com.QuizApp.Quiz.model.Quiz;
import com.QuizApp.Quiz.model.SubmitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String category, @RequestParam String title, @RequestParam int numQ) {
        return quizService.createQuiz(category, title, numQ);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionbyId(@PathVariable("id") int id) {
        return quizService.getQuestionbyid(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> getNumbersorRightAnswer(@PathVariable("id") int id, @RequestBody List<SubmitResponse> submitResponses) {
        return quizService.getNumbersorightAnswers( id, submitResponses);
    }
}

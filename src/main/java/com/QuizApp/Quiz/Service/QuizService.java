package com.QuizApp.Quiz.Service;

import com.QuizApp.Quiz.Dao.QuestionDao;
import com.QuizApp.Quiz.Dao.QuizDao;
import com.QuizApp.Quiz.model.Question;
import com.QuizApp.Quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String category, String title, int numQ) {
        try {
            List<Question> questions = questionDao.findRandomQuestionByCatgeory(category, numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle("checking");
            quiz.setQuestions(questions);
            quizDao.save(quiz);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);

        }
    }

}

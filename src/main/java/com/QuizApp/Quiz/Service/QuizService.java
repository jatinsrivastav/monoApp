package com.QuizApp.Quiz.Service;

import com.QuizApp.Quiz.Dao.QuestionDao;
import com.QuizApp.Quiz.Dao.QuizDao;
import com.QuizApp.Quiz.model.Question;
import com.QuizApp.Quiz.model.QuestionWrapper;
import com.QuizApp.Quiz.model.Quiz;
import com.QuizApp.Quiz.model.SubmitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);

            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
            return stringResponseEntity;

        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionbyid(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsfromdb;
        questionsfromdb = quiz.get().getQuestions();
        List<QuestionWrapper> questionWrappersforuser = new ArrayList<>();

        for (Question q : questionsfromdb) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getCategory(), q.getOption1(), q.getOption2(), q.getTitle());
            questionWrappersforuser.add(qw);
        }


        return new ResponseEntity<>(questionWrappersforuser, HttpStatus.OK);

    }


    public ResponseEntity<Integer> getNumbersorightAnswers(Integer id, List<SubmitResponse> submitResponses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0;
        int rightAnswer = 0;
        for (SubmitResponse response : submitResponses) {
            if (response.getResponse().equals(questions.get(i).getRightanswer())) {
               rightAnswer ++;
            }
            i++;
        }

        return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
    }
}

package com.QuizApp.Quiz.Service;


import com.QuizApp.Quiz.Dao.QuestionDao;
import com.QuizApp.Quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion(){
        return questionDao.findAll();
    }
}

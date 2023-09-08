package com.august.quizapp.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.august.quizapp.daos.QuestionDao;
import com.august.quizapp.daos.QuizDao;
import com.august.quizapp.models.Quiz;
import com.august.quizapp.models.Question;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    
    public Quiz createQuiz(String category, int numQ, String title) {
        Set<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuizQuestions(questions);

        quiz = quizDao.save(quiz);
        
        return quiz;
    }

}

package com.august.quizapp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.august.quizapp.daos.QuestionDao;
import com.august.quizapp.daos.QuizDao;
import com.august.quizapp.models.Quiz;
import com.august.quizapp.models.Question;
import com.august.quizapp.models.QuestionWrapper;

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

    public Set<QuestionWrapper> getQuiz(Integer id) {
        Optional<Quiz> optionalQuiz = quizDao.findById(id);
    
        if (optionalQuiz.isPresent()) {
            System.out.println();
            System.out.println("Quiz is present: " + optionalQuiz);
            Quiz quiz = optionalQuiz.get();
            Set<QuestionWrapper> questionWrappers = new HashSet<>();
            
            for (Question question : quiz.getQuizQuestions()) {
                QuestionWrapper questionWrapper = new QuestionWrapper();
                questionWrapper.setId(question.getId());
                questionWrapper.setQuestionTitle(question.getQuestionTitle());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());
                
                questionWrappers.add(questionWrapper);
            }
            
            return questionWrappers;
        } else {
            System.out.println();
            System.out.println("Quiz not found !");
            return null;
        }
    }
    

}

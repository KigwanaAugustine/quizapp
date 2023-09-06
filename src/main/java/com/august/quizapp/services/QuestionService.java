package com.august.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.august.quizapp.daos.QuestionDao;
import com.august.quizapp.models.Question;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String categoryName) {
        return questionDao.findAllByCategory(categoryName);
    }

    public Question createQuestion(Question question) {
        return questionDao.save(question);
    }

    public Question getQuestion(Integer id) {
        return questionDao.findById(id).orElse(null);
    }

    public Question updateQuestion(Question updatedQuestion) {
        return questionDao.save(updatedQuestion);
    }

    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }

   
    
}

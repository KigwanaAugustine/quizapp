package com.august.quizapp.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.august.quizapp.models.QuestionWrapper;
import com.august.quizapp.models.Quiz;
import com.august.quizapp.services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    
    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ , @RequestParam String title){
        Quiz quiz = quizService.createQuiz(category, numQ, title);
        return ResponseEntity.status(HttpStatus.CREATED).body(quiz);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Set<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        Set<QuestionWrapper> quiz = quizService.getQuiz(id);

        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

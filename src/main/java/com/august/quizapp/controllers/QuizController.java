package com.august.quizapp.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.august.quizapp.models.QuestionWrapper;
import com.august.quizapp.models.Quiz;
import com.august.quizapp.models.Response;
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

        return (quiz != null) 
            ? ResponseEntity.ok(quiz) 
            : ResponseEntity.notFound().build();
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        if (responses.isEmpty()) {
            return ResponseEntity.badRequest().body(0);
        }

        Integer score = quizService.calculateScore(id, responses);

        return (score != null)
            ? ResponseEntity.ok(score)
            : ResponseEntity.notFound().build();
    }


}

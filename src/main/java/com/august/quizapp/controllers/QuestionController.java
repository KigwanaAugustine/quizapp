package com.august.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.august.quizapp.models.Question;
import com.august.quizapp.services.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("{id}")
    public Question getQuestion(@PathVariable Integer id){
        return questionService.getQuestion(id);
    }

    @GetMapping("category/{categoryName}")
    public List<Question> getQuestionsByCategory(@PathVariable("categoryName") String categoryName) {
        return questionService.getQuestionsByCategory(categoryName);
    }

    @PostMapping("add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @PutMapping("update/{id}")
    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) throws Exception {
        // First, retrieve the existing question by its ID
        Question existingQuestion = questionService.getQuestion(id);
        
        // Check if the existing question exists
        if (existingQuestion == null) {
            // Handle the case where the question with the given ID is not found
            throw new Exception("Question with ID " + id + " not found");
        }else{
            // Update the properties of the existing question with the new data
            return questionService.updateQuestion(updatedQuestion);
        }
        
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        // First, check if the question with the given ID exists
        Question existingQuestion = questionService.getQuestion(id);
    
        if (existingQuestion == null) {
            // If the question doesn't exist, return a not found response
            return ResponseEntity.notFound().build();
        }
    
        // If the question exists, delete it
        questionService.deleteQuestion(id);
    
        // Return a success response
        return ResponseEntity.ok("Question with ID " + id + " has been deleted.");
    }
    


}

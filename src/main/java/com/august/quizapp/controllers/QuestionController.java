// package com.august.quizapp.controllers;

// import java.util.List;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.august.quizapp.models.Question;
// import com.august.quizapp.services.QuestionService;

// @RestController
// @RequestMapping("question")
// public class QuestionController {

//     @Autowired
//     QuestionService questionService;

//     @GetMapping("allQuestions")
//     public ResponseEntity<List<Question>> getAllQuestions(){
//         return ResponseEntity.ok(questionService.getAllQuestions());
//     }

//     @GetMapping("{id}")
//     public ResponseEntity<Question> getQuestion(@PathVariable Integer id) {
//         Question question = questionService.getQuestion(id);
//         return question != null 
//                ? ResponseEntity.ok(question) 
//                : ResponseEntity.notFound().build();
//     }

//     @GetMapping("category/{categoryName}")
//     public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String categoryName) {
//         List<Question> questions = questionService.getQuestionsByCategory(categoryName);
//         return ResponseEntity.ok(questions);
//     }

//     @PostMapping("add")
//     public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
//         Question createdQuestion = questionService.createQuestion(question);
//         return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
//     }

//     @PutMapping("update/{id}")
//     public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
//         try {
//             // First, retrieve the existing question by its ID
//             Question existingQuestion = questionService.getQuestion(id);
            
//             // Check if the existing question exists
//             if (existingQuestion == null) {
//                 // Return a 404 Not Found response if the question with the given ID is not found
//                 return ResponseEntity.notFound().build();
//             }
    
//             // Use ternary operators to update attributes only if they are not null
//             existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle() != null ?
//                 updatedQuestion.getQuestionTitle() : existingQuestion.getQuestionTitle());
    
//             existingQuestion.setOption1(updatedQuestion.getOption1() != null ?
//                 updatedQuestion.getOption1() : existingQuestion.getOption1());
    
//             existingQuestion.setOption2(updatedQuestion.getOption2() != null ?
//                 updatedQuestion.getOption2() : existingQuestion.getOption2());
    
//             existingQuestion.setOption3(updatedQuestion.getOption3() != null ?
//                 updatedQuestion.getOption3() : existingQuestion.getOption3());
    
//             existingQuestion.setOption4(updatedQuestion.getOption4() != null ?
//                 updatedQuestion.getOption4() : existingQuestion.getOption4());
    
//             existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer() != null ?
//                 updatedQuestion.getRightAnswer() : existingQuestion.getRightAnswer());
    
//             existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel() != null ?
//                 updatedQuestion.getDifficultyLevel() : existingQuestion.getDifficultyLevel());
    
//             existingQuestion.setCategory(updatedQuestion.getCategory() != null ?
//                 updatedQuestion.getCategory() : existingQuestion.getCategory());
    
//             // Save the updated question
//             Question updated = questionService.updateQuestion(existingQuestion);
    
//             // Return a 200 OK response with the updated question
//             return ResponseEntity.ok(updated);
//         } catch (Exception e) {
//             // Handle other exceptions if necessary
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//         }
//     }
    
    
    
//     @DeleteMapping("delete/{id}")
//     public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
//         // First, check if the question with the given ID exists
//         Question existingQuestion = questionService.getQuestion(id);
    
//         if (existingQuestion == null) {
//             // If the question doesn't exist, return a not found response
//             return ResponseEntity.notFound().build();
//         }
    
//         // If the question exists, delete it
//         questionService.deleteQuestion(id);
    
//         // Return a success response
//         return ResponseEntity.ok("Question with ID " + id + " has been deleted.");
//     }
    
// }

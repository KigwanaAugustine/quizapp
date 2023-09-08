package com.august.quizapp.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    // @JoinTable(
        //     name = "quiz_questions", 
        //     joinColumns = @JoinColumn(name = "quiz_id"), 
        //     inverseJoinColumns = @JoinColumn(name = "question_id"))
    @ManyToMany
    private Set<Question> quizQuestions;
    
}

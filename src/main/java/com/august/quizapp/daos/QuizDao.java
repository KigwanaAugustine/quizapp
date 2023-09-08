package com.august.quizapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.august.quizapp.models.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}

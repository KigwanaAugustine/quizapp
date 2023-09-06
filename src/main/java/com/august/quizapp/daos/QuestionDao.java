package com.august.quizapp.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.august.quizapp.models.Question;

// @RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

    List<Question> findAllByCategory(String categoryName);
    
}

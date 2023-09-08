package com.august.quizapp.daos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.august.quizapp.models.Question;

// @RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

    List<Question> findAllByCategory(String categoryName);

    @Query(value = "SELECT * FROM questions WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    Set<Question> findRandomQuestionsByCategory(String category, int numQ);
    
}

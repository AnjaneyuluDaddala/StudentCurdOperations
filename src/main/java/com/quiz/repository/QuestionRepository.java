package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

	List<Question> findByCategory(String category);

	//we are writing sql or native queries
	//now we are using native queries.
	
	@Query(value = "select * from Question q where q.category=:category order by RAND() limit :numQ", nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category,int numQ);
	


}

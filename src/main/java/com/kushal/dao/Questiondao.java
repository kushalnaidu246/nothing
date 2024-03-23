package com.kushal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kushal.model.Question;

@Repository
public interface Questiondao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value="SELECT q.question_id FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	List<Integer> findRandomQuestionByCategory(String category, Integer numQ);
	

	

}

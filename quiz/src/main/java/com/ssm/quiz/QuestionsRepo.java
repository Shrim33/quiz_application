package com.ssm.quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepo extends JpaRepository<Question, Integer> {
	
	public List<Question> findByCategory(String category);
	
	List<Question> findByDifficultyLevel(String difficultyLevel);

	@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	public List<Question> findRandomQuestionByCategory(String category,int numQ);

	@Query(value="select * from question q order by Random() limit:numQ",nativeQuery = true)
	public List<Question> findByAllQuestion(int numQ);

}

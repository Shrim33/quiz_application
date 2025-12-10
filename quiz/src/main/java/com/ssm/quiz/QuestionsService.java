package com.ssm.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {

	@Autowired
	QuestionsRepo questionsRepo;

	public ResponseEntity<List<Question>> getQuestions() {
		try {
			List<Question> list = questionsRepo.findAll();
			System.out.println(list);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getAllCategory(String category) {
		try {
		List<Question> list = questionsRepo.findByCategory(category);
		System.out.println(list);
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);
	
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
        questionsRepo.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new String(),HttpStatus.BAD_REQUEST);
    }

	// ============================================================================
	public List<Question> getAllDLQ(String difficulty_level) {

		List<Question> list = questionsRepo.findByDifficultyLevel(difficulty_level);
		System.out.println(list);
		return list;
	}

	// ====================================================================================
//========================================================
	public Optional<Question> userIdInf(int id) {
		Optional<Question> list = questionsRepo.findById(id);

		return list;
	}
	
	public void delId(int id){
		questionsRepo.deleteById(id);
		System.out.println("deleted");
	}
//=============================================================
}

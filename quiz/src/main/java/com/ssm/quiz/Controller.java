package com.ssm.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ques")
public class Controller {

	private final QuestionsRepo questionsRepo;

	@Autowired
	QuestionsService questionsService;

	Controller(QuestionsRepo questionsRepo) {
		this.questionsRepo = questionsRepo;
	}

	@GetMapping("quiz")
	public ResponseEntity<List<Question>> getQ() {
		return questionsService.getQuestions();
	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getCategory(@PathVariable("category") String category) {

		return questionsService.getAllCategory(category);
	}

	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionsService.addQuestion(question);
	}
	

	// my
	// method================================================================================
	@GetMapping("difficulty_level/{difficulty_level}")
	public List<Question> getDQ(@PathVariable("difficulty_level") String difficulty_level) {

		return questionsService.getAllDLQ(difficulty_level);

	}// =======================================================================

	// my method =======================================================
	@GetMapping("userid/{id}")
	public Optional<Question> userIdInfo(@PathVariable int id) {

		Optional<Question> list = questionsService.userIdInf(id);
		return list;
	}
	
	@PostMapping("del/{id}")
	public void deleteId(@PathVariable @RequestBody int id) {
		questionsService.delId(id);
	}
	// ==================================================================

}

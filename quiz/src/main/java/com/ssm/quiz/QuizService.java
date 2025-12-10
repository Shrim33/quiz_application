package com.ssm.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionsRepo questionsRepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		try {

			List<Question> ques = questionsRepo.findRandomQuestionByCategory(category, numQ);

			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(ques);
			quizDao.save(quiz);

			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fill correct Info", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		try {
			Thread thread=new Thread();

			Optional<Quiz> quiz = quizDao.findById(id);
			List<Question> quesFromDB = quiz.get().getQuestions();
			List<QuestionWrapper> questionForUser = new ArrayList<>();

			for (Question q : quesFromDB) {
				QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(),
						q.getOption2(), q.getOption3(), q.getOption4());
				questionForUser.add(qw);
			}
			
			thread.sleep(1000);
			return new ResponseEntity<>(questionForUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		int right = 0;
		try {

			Quiz quiz = quizDao.findById(id).get();
			List<Question> question = quiz.getQuestions();

			int i = 0;
			for (Response resp : response) {
				if (resp.getResponse().equals(question.get(i).getRight_answer()))
					right++;

				i++;
			}

			return new ResponseEntity<>(right, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(right, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<String> getAllQWALLC(int numQ, String title) {
		
		List<Question> l=questionsRepo.findByAllQuestion(numQ);
		
		return new ResponseEntity<>("Questions are Created",HttpStatus.OK);

		
	}

}

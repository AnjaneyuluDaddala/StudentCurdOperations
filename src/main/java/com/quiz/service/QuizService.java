package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Quiz;
import com.quiz.model.ResponseQuiz;
import com.quiz.repository.QuestionRepository;
import com.quiz.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepo;
	
	@Autowired
	private QuestionRepository questionRepo;

	
	//creating user of category based and random no of questions and our custom title.
	public ResponseEntity<String> creatingQuiz(String category, int numQ, String title) {
		
		List<Question> questions= this.questionRepo.findRandomQuestionByCategory(category,numQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("successful",HttpStatus.CREATED);
	}
	
	//sending the quiz of questions and options to user.

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		  Optional<Quiz> quiz = this.quizRepo.findById(id);
		  List<Question> questionsDB = quiz.get().getQuestions();
		  
		  List<QuestionWrapper>questionForUser=new ArrayList<>();
		  
		  for(Question q:questionsDB) {
			 QuestionWrapper qw=new QuestionWrapper();
			 qw.setId(q.getId());
			 qw.setOption1(q.getOption1());
			 qw.setOption2(q.getOption2());
			 qw.setOption3(q.getOption3());
			 qw.setOption4(q.getOption4());
			 qw.setQuestionTitle(q.getQuestionTitle());
			 
			 questionForUser.add(qw);
		  }
		  
		  return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		  
		  
	}
	//comparing response options and correct options and getting score.

	public ResponseEntity<Integer> submitQuiz(Integer id, List<ResponseQuiz> response) {
	    Optional<Quiz> optionalQuiz = this.quizRepo.findById(id);
	    if (!optionalQuiz.isPresent()) {
	        // If the quiz is not found, return a 404 response.
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    Quiz quizDB = optionalQuiz.get();
	    List<Question> questions = quizDB.getQuestions();

	    if (questions == null || questions.isEmpty()) {
	        // If there are no questions in the quiz, return 0 correct answers.
	        return new ResponseEntity<>(0, HttpStatus.OK);
	    }

	    int right = 0;
	    int i = 0;

	    for (ResponseQuiz r : response) {
	        if (i >= questions.size()) {
	            // If the response list is longer than the questions list, stop processing.
	            break;
	        }

	        String givenAnswer = r.getResponse();
	        String correctAnswer = questions.get(i).getRightAnswer();

	        System.out.println("Question " + (i + 1) + ": givenAnswer=" + givenAnswer + ", correctAnswer=" + correctAnswer);

	        if (givenAnswer != null && givenAnswer.equals(correctAnswer)) {
	            right++;
	            System.out.println("Correct answer for question " + (i + 1));
	        } else {
	            System.out.println("Incorrect answer for question " + (i + 1));
	        }

	        i++;
	    }

	    System.out.println("Total correct answers: " + right);
	    return new ResponseEntity<>(right, HttpStatus.OK);
	}

}

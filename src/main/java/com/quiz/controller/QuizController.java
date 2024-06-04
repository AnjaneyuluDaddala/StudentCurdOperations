package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.QuestionWrapper;
import com.quiz.model.ResponseQuiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService Qserv;
	
   @PostMapping("/createQuiz")
   public ResponseEntity<String> creatingQuiz(@RequestParam("category") String category,@RequestParam("numQ") int numQ,@RequestParam("title") String title){
	 return this.Qserv.creatingQuiz(category,numQ,title);
	
  }
   
   /*
    * Now ,every quiz have multiple questions
    * it may be repeat.so we used many to many.
    * here in one quiz have same id and different of question id.
    * 
    * now,I want to fetch the quiz.To mention quiz id we get those questions..
    */
   
   
   /*
    * every question have fetch the title,options.create question wrapper.
    */
   
   @GetMapping("/get/{id}")
   public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){
	   return this.Qserv.getQuizQuestions(id);
	   
   }
   
   /*
    * now ,we get questions and options
    * now user,is select options and submit
    * to compare select option and right answers.
    * we are return score from this.
    */
   
   
   @PostMapping("/submit/{id}")
   public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<ResponseQuiz> response){
	   return this.Qserv.submitQuiz(id,response);
	   
   }
   
}

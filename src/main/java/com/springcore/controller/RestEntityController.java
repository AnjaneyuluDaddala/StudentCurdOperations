package com.springcore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.model.StudentModel;

//@RestController
//@RequestMapping("/students")
public class RestEntityController {
	
	 private final List<StudentModel> students = new ArrayList<>();
	 
	 //getting based on student id

	    @GetMapping("/{id}")
	    public ResponseEntity<StudentModel> getStudentById(@PathVariable int id) {
	        Optional<StudentModel> student = findStudentById(id);
	        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    
	    
	    
       // Entering in ui and saving database.
	    
	    @PostMapping("/create")
	    public ResponseEntity<String> createStudent(@RequestBody StudentModel student) {
	        students.add(student);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Student created: " + student.getName());
	    }
	    
	    
	    
          // updating the student data in database
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentModel updatedStudent) {
	        Optional<StudentModel> studentOptional = findStudentById(id);
	        if (studentOptional.isPresent()) {
	            StudentModel existingStudent = studentOptional.get();
	            
	            existingStudent.setName(updatedStudent.getName());
	            
	            existingStudent.setMarks(updatedStudent.getMarks());
	            
	            existingStudent.setSchool(updatedStudent.getSchool());
	            
	            return ResponseEntity.ok("Student updated: " + existingStudent.getName());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    
	    
         // removing student data based on student id.
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
	        Optional<StudentModel> studentOptional = findStudentById(id);
	        if (studentOptional.isPresent()) {
	            StudentModel student = studentOptional.get();
	            students.remove(student);
	            return ResponseEntity.ok("Student deleted: " + student.getName());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    
	    

	    // Utility method to find a student by ID
	    
	    private Optional<StudentModel> findStudentById(int id) {
	        return students.stream().filter(student -> student.getId() == id).findFirst();
	    }
	}



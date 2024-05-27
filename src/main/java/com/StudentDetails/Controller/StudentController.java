package com.StudentDetails.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	private StudentServiceImpl service;
	
	
	@GetMapping("/")
	public String getWorking() {
		return "working";
	}
	
	
	//saving the data 
	@PostMapping("/save")
	public String saveData(@RequestParam("stdid")Long id,
			                @RequestParam("stdName")String name,
			                @RequestParam("course")String course,
			                @RequestParam("parentName")String Parent) {
		
		Student std=new Student(id,name,course,Parent);
		
		
		this.service.saveStudent(std);
		
		return "data is saved";
		
		
		
	}
	
	//getting the data
	
	@GetMapping("/getData")
	public List<Student> getData() {
	    List<Student> list = service.getData();
	    
	    return list;
	}
	
	
	//deleting data
	
	@DeleteMapping("/removingData")
	public String deleteData(@RequestParam("id")Long id) {
		
		
	   this.service.removedata(id);
		
		return "data is removed of="+id;
	}
	
	
	//updating data
	
	@PostMapping("/updateData")
	public String updateData(@RequestBody Student std) {
	   this.service.updateStudent(std);
		return "updated in database";
	}
	
	
}
package com.springcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.model.StudentModel;



@RestController
@RequestMapping("/student")
public class HomeController {
	
	
	//using RequsetBody
	@PostMapping("/savaData")
	public String save(@RequestBody StudentModel std) {
		System.out.println("Studnet details "+std);
		return "data is saved in database";
		
	}
	
	//using pathVariable
	
	@GetMapping("/{name}/{age}")
	public String getSupplier(@PathVariable String name,@PathVariable int age) {
		
		String result="The name of Student "+name+" and age is "+age;
		System.out.println(result);
		return result;
		
	}
	
	//RequestMapping
	
	@GetMapping("/getdetails")
	public String suppliers(@RequestParam("name")String Fname,@RequestParam("age")int age) {
		
		String result="The name of Student "+Fname+" and age is "+age;
		System.out.println(result);
		return result;
		
	}
	
	//using ListObj
	//passing data through list
	
	@PostMapping("/listdata")
	public List<StudentModel> listSuppliers(@RequestBody StudentModel std){
		
	   double[] marks1= {89.9,78.8};
      StudentModel s1=new StudentModel(2,"Prasanna",marks1,"model School");

	   double[] marks2= {89.9,78.8};
      StudentModel s2=new StudentModel(2,"Prasanna",marks2,"model School");

	   double[] marks3= {89.9,78.8};
     StudentModel s3=new StudentModel(2,"Prasanna",marks3,"model School");

	   double[] marks4= {89.9,78.8};
      StudentModel s4=new StudentModel(2,"Prasanna",marks4,"model School");
		
		List<StudentModel>list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		return list;
	}
	

}

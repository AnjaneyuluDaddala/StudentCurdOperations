package com.StudentApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentApplication.Dao.StudentDao;

import com.StudentApplication.Model.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao StdDao;

	@GetMapping("/")
	public String getLogin(Model model) {
		model.addAttribute("login", "Login Form");
		return "login";
	}
	
	@GetMapping("homePage")
	public String getHome(@RequestParam("user")String user,@RequestParam("pass")String pass,Model m) {
		if(user.equals("11912504") && pass.equals("Anji@123")) {
			m.addAttribute("name", "Anjan");
			return "home";
		}else {
			m.addAttribute("errorMsg", "Incorrext!check username and password");
			return "login";	
		}	
	}
	
	@GetMapping("showStudents")
	public String getStudents(Model m) {
		List<Student> students = StdDao.loadStudents();
		/*
		for (Student std : students) {
			System.out.println(std);	
		}*/
		
		m.addAttribute("students",students);
		return "home";
	}
}

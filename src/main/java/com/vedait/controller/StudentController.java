package com.vedait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedait.entity.LoginModel;
import com.vedait.entity.LoginResponse;
import com.vedait.entity.StudentRegister;
import com.vedait.entity.StudentRegisterModel;
import com.vedait.service.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vedait")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl service;
	
	
	@PostMapping("/stdRegister")
	 public String saveEmployee(@RequestBody StudentRegisterModel std)
    {
        String id = this.service.addStudents(std);
        return id;
    }
	
//	@PostMapping("/stdLogin")
//	public ResponseEntity<String>loginStudent(@PathVariable String email,@PathVariable String password){
//		return this.service.loginStudent(email,password);
//	}

    @PostMapping(path="/stdLogin")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginModel loginModel)
    {
        LoginResponse loginResponse = service.loginEmployee(loginModel);
        return ResponseEntity.ok(loginResponse);
    }
    

    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/try")
    public List<StudentRegister> getStudents(){
    	return this.service.getStudents();
  
	}
	
	
}

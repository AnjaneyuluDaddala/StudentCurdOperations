package com.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.model.StudentLogin;
import com.springcore.model.StudentRegister;
import com.springcore.payLoadMsgs.LoginMessage;
import com.springcore.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class StudentLoginController {
	
	@Autowired
	private LoginService studServ;
	
	
	@PostMapping(path="/save")
	public String saveLoginDetails( @RequestBody StudentRegister stdR) {
		
		String studentName = studServ.saveStudentLogin(stdR);
		return "welcome to "+studentName;
		
	}
	
	@PostMapping(path="/loginStd")
	public ResponseEntity<?> loginStudent(@RequestBody StudentLogin stdL) {
		
		LoginMessage loginMsg=studServ.loginMsg(stdL);
		return ResponseEntity.ok(loginMsg);
		
	}

}

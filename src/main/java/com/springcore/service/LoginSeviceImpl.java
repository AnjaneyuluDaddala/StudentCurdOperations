package com.springcore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springcore.entity.Student;
import com.springcore.model.StudentLogin;
import com.springcore.model.StudentRegister;
import com.springcore.payLoadMsgs.LoginMessage;
import com.springcore.repository.LoginRepo;
@Service
public class LoginSeviceImpl implements LoginService{
	
	
	 @Autowired
 	private LoginRepo repo;	
 	
 	@Autowired
	private PasswordEncoder passEncoder;

	
	
	@Override
	public String saveStudentLogin(StudentRegister stdlog) {
		
		Student std=new Student(
				stdlog.getStdId(),
				stdlog.getStdName(),
				stdlog.getStdEmail(),
				this.passEncoder.encode(stdlog.getStdPassword()));
		
		
		
		
		if (stdlog.getStdPassword()!=null) {
            String encodedPassword = passEncoder.encode(stdlog.getStdPassword());
            stdlog.setStdPassword(encodedPassword);
        } else {
            // Handle null rawPassword case appropriately, maybe throw an exception or log an error
            throw new IllegalArgumentException("Raw password cannot be null");
        }
		
		
		
		repo.save(std);
		
		return  std.getStdName();
		
		
	}



	@Override
	public LoginMessage loginMsg(StudentLogin stdLog) {
//		 String msg="";
		 Student studentR=repo.findByEmail(stdLog.getEmail());
		 if(studentR!=null) {
			 String password = stdLog.getPassword();
			 String encodePassword = studentR.getPassword();
			 boolean matches = passEncoder.matches(password, encodePassword);
			 if(matches) {
				
				 Optional<Student> student= repo.findByEmailAndPassword(studentR.getEmail(),studentR.getPassword());
			 
			 if(student.isPresent()) {
				 return new LoginMessage("login Success",true);
			 }else{
				 return new LoginMessage("login failed",false);
				 
			 }
				 
			 }else {
				 return new LoginMessage("Password not Match",false);
				 
			 }

			 
		 }else{
			 return new LoginMessage("Email not exists",false);
			 
		 }



	}
}

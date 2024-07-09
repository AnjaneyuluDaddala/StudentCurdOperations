package com.springcore.service;



import com.springcore.model.StudentLogin;
import com.springcore.model.StudentRegister;
import com.springcore.payLoadMsgs.LoginMessage;


public interface LoginService {
	
	String saveStudentLogin(StudentRegister stdReg) ;
	
    LoginMessage loginMsg(StudentLogin stdLog);
}

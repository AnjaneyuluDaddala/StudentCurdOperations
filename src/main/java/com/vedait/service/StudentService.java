package com.vedait.service;

import com.vedait.entity.LoginResponse;
import com.vedait.entity.LoginModel;
import com.vedait.entity.StudentRegisterModel;

public interface StudentService {
	
	String addStudents(StudentRegisterModel student);
	LoginResponse loginEmployee(LoginModel loginModel);

}

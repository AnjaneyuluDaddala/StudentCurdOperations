package com.vedait.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.vedait.entity.LoginModel;
import com.vedait.entity.LoginResponse;
import com.vedait.entity.StudentRegister;
import com.vedait.entity.StudentRegisterModel;
import com.vedait.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private PasswordEncoder pswd;



	/*
	 * public ResponseEntity<String> loginStudent(String email,String password) {
	 * StudentRegister studentcontrol = studentRepo.findByEmail(email);
	 * 
	 * if(studentcontrol.getEmail()!=null) {
	 * 
	 * if(pswd.matches(password, studentcontrol.getPassword())){
	 * Optional<StudentRegister> studentDB =
	 * studentRepo.findByEmailPassword(studentcontrol.getEmail(),
	 * studentcontrol.getPassword());
	 * 
	 * if(studentDB.isPresent()) { return ResponseEntity.ok("	Login successfull");
	 * }else { return ResponseEntity.ok("	Login failed"); }
	 * 
	 * }else { return ResponseEntity.ok("Password doesnot match"); } }
	 * 
	 * else { return ResponseEntity.ok("Email is not exist"); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	

	@Override
	public String addStudents(StudentRegisterModel student) {
		String password=pswd.encode(student.getPassword());
		StudentRegister std=new StudentRegister(student.getId(),student.getName(),student.getEmail(),password);
		this.studentRepo.save(std);
		return std.getStudentName();
	}


	@Override
	public LoginResponse loginEmployee(LoginModel loginModel) {
		 String msg = "";
	        StudentRegister stdDB = studentRepo.findByEmail(loginModel.getEmail());
	        if (stdDB != null) {
	            Boolean isPwdRight = pswd.matches(loginModel.getPassword(), stdDB.getPassword());
	            if (isPwdRight) {
	                Optional<StudentRegister> employee = studentRepo.findOneByEmailAndPassword(loginModel.getEmail(), stdDB.getPassword());
	                if (employee.isPresent()) {
	                    return new LoginResponse("Login Success", true);
	                } else {
	                    return new LoginResponse("Login Failed", false);
	                }
	            } else {
	                return new LoginResponse("password Not Match", false);
	            }
	        }else {
	            return new LoginResponse("Email not exits", false);
	        }
	    }
	
	
	public List<StudentRegister> getStudents(){
		List<StudentRegister> stdList=studentRepo.findAll();
		return stdList;
	}
}
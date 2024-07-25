package com.StudentDetails.service;



import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.repository.StudentRepostiory;

@Service
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	private StudentRepostiory repo;
	
	//inserting data
	@Override
	public Student saveStudent(Student std) {
		Student save = this.repo.save(std);
		return save;
		
	}
	
	
	//find by studentId
	public Student findByStudentId(Long studentId) {
		try {
			return this.repo.findById(studentId).orElseThrow(()->new UserPrincipalNotFoundException("Student not found!"));
		} catch (UserPrincipalNotFoundException e) {
		   e.printStackTrace();
		   return null;
		}
		
	}
	
	
	//get data in dataBase
	
	public List<Student> getData() {
		
		List<Student> findStudentData = this.repo.findAll();
		return findStudentData;
	}
	
	
	
	//deleting data in dataBase
	
	public void removedata(Long id) {
		
		this.repo.deleteById(id);
	}
	
	//updating data in database
	
	public Student updateStudent(Student std) {
	    Optional<Student> studentOptional = repo.findById(std.getStudentid());
	    if (studentOptional.isPresent()) {
	        Student student = studentOptional.get();
	        student.setCourse(std.getCourse());
	        student.setParentName(std.getParentName());
	        student.setStudentName(std.getStudentName());
	        return repo.save(student);  // Save the updated student entity
	    } else {
	        throw new RuntimeException("Student not found with id " + std.getStudentid());
	    }
	}

	
	
	

}

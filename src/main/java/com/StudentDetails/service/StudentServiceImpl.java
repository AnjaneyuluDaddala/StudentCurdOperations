package com.StudentDetails.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDetails.Entity.Student;
import com.StudentDetails.repository.StudentRepostiory;

@Service
public class StudentServiceImpl {
	
	
	@Autowired
	private StudentRepostiory repo;
	
	//saving data
	
	public Student saveStudent(Student std) {
		Student save = this.repo.save(std);
		return save;
		
	}
	
	//get data in dataBase
	
	public List<Student> getData() {
		
		List<Student> findStudnetData = this.repo.findAll();
		return findStudnetData;
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
            return repo.save(std);
        } else {
            throw new RuntimeException("Student not found with id " + std.getStudentid());
        }
	}
	
	
	

}

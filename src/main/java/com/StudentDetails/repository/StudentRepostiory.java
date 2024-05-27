package com.StudentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentDetails.Entity.Student;

@Repository
public interface StudentRepostiory extends JpaRepository<Student,Long>{
	

}

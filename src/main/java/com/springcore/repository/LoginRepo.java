package com.springcore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springcore.entity.Student;

@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Student, Integer>{
	
	Student findByEmail(String email);
	  
	Optional<Student>findByEmailAndPassword(String email,String password);

}

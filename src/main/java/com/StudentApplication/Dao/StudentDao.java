package com.StudentApplication.Dao;

import java.util.List;

import com.StudentApplication.Model.Student;

public interface StudentDao {
	
   List<Student> loadStudents();
}

package com.StudentApplication.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.StudentApplication.Model.Student;

public class StudentRowmapper implements RowMapper<Student>{
	

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student=new Student();
	  student.setId(rs.getInt("StdId"));
	  student.setName(rs.getString("StdName"));
	  student.setSchool(rs.getString("school"));
	  student.setFee(rs.getDouble("StdFee"));
		return student;
	}
	
}

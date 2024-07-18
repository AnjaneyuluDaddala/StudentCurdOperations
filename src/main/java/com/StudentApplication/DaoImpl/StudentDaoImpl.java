package com.StudentApplication.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.StudentApplication.Dao.StudentDao;
import com.StudentApplication.Model.Student;
import com.StudentApplication.rowMapper.StudentRowmapper;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
		String sql="select * from students";
		List<Student> Thestudentlist = jdbcTemplate.query(sql, new StudentRowmapper());
		return Thestudentlist;
	}

}

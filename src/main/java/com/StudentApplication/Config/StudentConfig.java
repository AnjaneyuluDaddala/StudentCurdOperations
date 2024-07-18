package com.StudentApplication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class StudentConfig {
	
	@Bean("dataSource")
	@Scope("singleton")
	DriverManagerDataSource getDataSrc() {
		DriverManagerDataSource s=new DriverManagerDataSource();
		 s.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 s.setUsername("root");
		 s.setUrl("jdbc:mysql://localhost:3306/Vedait");
		 s.setPassword("Anji@123");
		 return s;
	}
	
	
	@Bean("jdbcTemplate")
	JdbcTemplate getDataJdbcT() {
		JdbcTemplate j=new JdbcTemplate();
		j.setDataSource(getDataSrc());
		return j;
	}

}

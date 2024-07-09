package com.springcore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_Login")
public class Student {
	
	@Id
	@Column(name="studentid",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="stdName",length=223)
	private String stdName;
	
	@Column(name="email",length=223)
	private String email;
	
	@Column(name="password",length=223)
	private String password;
	
	public Student() {
		
	}

	public Student(int id, String stdName, String email, String password) {
	
		this.id = id;
		this.stdName = stdName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stdName=" + stdName + ", email=" + email + ", password=" + password + "]";
	}
}

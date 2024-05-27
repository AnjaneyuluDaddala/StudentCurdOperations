package com.StudentDetails.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="stdid")
	private Long studentid;
	@Column(name="stdName")
	private String studentName;
	@Column(name="course")
	private String course;
	@Column(name="parent")
	private String parentName;
	
	public Student() {
		
		
	}
	public Student(Long studentid, String studentName, String course, String parentName) {
		super();
		this.studentid = studentid;
		this.studentName = studentName;
		this.course = course;
		this.parentName = parentName;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentName=" + studentName + ", course=" + course
				+ ", parentName=" + parentName + "]";
	}


	


}


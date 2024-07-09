package com.springcore.model;

import java.util.Arrays;

public class StudentModel {
	
	private int id;
	private String name;
	private double[] marks;
	private String school;
	
	
	
	public StudentModel() {
		
	}



	public StudentModel(int id, String name, double[] marks, String school) {
	
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.school = school;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double[] getMarks() {
		return marks;
	}



	public void setMarks(double[] marks) {
		this.marks = marks;
	}



	public String getSchool() {
		return school;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + Arrays.toString(marks) + ", school=" + school
				+ "]";
	}
	

}

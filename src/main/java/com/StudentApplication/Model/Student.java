package com.StudentApplication.Model;

public class Student {
	 @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + ", fee=" + fee + "]";
	}
	 private  int id ; 
     private String name;
     private String school;
     private double fee;
     
     public Student() {
    	 
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}

}

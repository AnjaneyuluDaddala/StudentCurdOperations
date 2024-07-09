package com.springcore.model;

public class StudentRegister {
	
	private int stdId;
	private String stdName;
	private String stdEmail;
	private String stdPassword;
	
	
	public StudentRegister(int stdId, String stdName, String stdEmail, String stdPassword) {
	
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdEmail = stdEmail;
		this.stdPassword = stdPassword;
	}
	
	public StudentRegister() {
		
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	public String getStdPassword() {
		return stdPassword;
	}

	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}

	@Override
	public String toString() {
		return "StudentRegister [stdId=" + stdId + ", stdName=" + stdName + ", stdEmail=" + stdEmail + ", stdPassword="
				+ stdPassword + "]";
	}

	
	

}

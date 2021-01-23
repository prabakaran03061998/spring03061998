package com.abytz.model;

public class Student {
	
	private String regNo;
	private String studentName;
	private String email;
	private String password;

	public Student()
	{
		
	}
	public Student(String regNo,String studentName,String email,String password)
		{
			super();
			this.regNo=regNo;
			this.studentName=studentName;
			this.email=email;
			this.password=password;
		}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
		return "Student [regNo=" + regNo + ", studentName=" + studentName + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
}
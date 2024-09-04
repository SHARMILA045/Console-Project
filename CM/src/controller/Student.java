package controller;

import java.sql.SQLException;

import Model.StudentDao;

public class Student {
      private String Register_no;
      private String Student_name;
      private String department;
      private String batch;
      private String mailid ;
      private String password;
	public Student(String register_no, String student_name, String department, String batch, String mailid,
			String password) {
		this.Register_no = register_no;
		this.Student_name = student_name;
		this.department = department;
		this.batch = batch;
		this.mailid = mailid;
		this.password = password;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getRegister_no() {
		return Register_no;
	}
	public void setRegister_no(String register_no) {
		Register_no = register_no;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student studentLogin(Student s1) throws SQLException {
		Student st1 = StudentDao.studentLogin(s1);
		if(st1.getPassword()!=null && s1.getPassword().equals(st1.getPassword())) {
			return st1;
		}
		else {
			return null;
		}
	}
	public void viewCourse() throws SQLException {
	   Student st11 = StudentDao.courseView(); 
	}
	
      
}

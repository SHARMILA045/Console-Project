package controller;

import java.sql.SQLException;

import Model.AdminDao;

public class Admin {
	 private int Admin_ID;
     private String UserName;
     private String Department;
     private String Email_ID;
     private String Password;

	
     public Admin(int admin_ID, String userName, String department, String email_ID, String password) {
    	 this.Admin_ID = admin_ID;
    	 this.UserName = userName;
    	 this.Department = department;
    	 this.Email_ID = email_ID;
    	 this.Password = password;
     }


	public Admin() {
		// TODO Auto-generated constructor stub
	}


	public int getAdmin_ID() {
		return Admin_ID;
	}


	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	public String getEmail_ID() {
		return Email_ID;
	}


	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public void adminLogin1(Admin a1) {
		// TODO Auto-generated method stub
		
	}


	public Admin adminLogin(Admin a1) throws SQLException {
		Admin ad1 =AdminDao.adminLogin(a1);
		if(ad1.getPassword()!=null && a1.getPassword().equals(ad1.getPassword())) {
			return ad1;
		}
		else {
			return null;
		}
	}


}


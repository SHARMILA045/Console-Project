package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Course_DAO;

public class CourseList {
      private int cid;
      private String cname;
      private String domain;
      private int modules;
      
      
      
      public CourseList(int cid, String cname, String domain, int modules) {
    	  this.cid = cid;
    	  this.cname = cname;
    	  this.domain = domain;
    	  this.modules = modules;
      }
      
      
	public CourseList() {
		// TODO Auto-generated constructor stub
	}


	public CourseList(int cid2) {
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}


	public int getModules() {
		return modules;
	}


	public void setModules(int module) {
		this.modules = module; 
				
	}

	public static ArrayList<CourseList> viewCourse() throws SQLException {
		ArrayList<CourseList> ac1 =Course_DAO.dbViewCourse();
		return ac1;
	}




	public void addCourse(CourseList cl) throws SQLException {
		Course_DAO a = new Course_DAO();
		Course_DAO.addCourse(cl);
		
	}




//	public void setCsid(int cid2) {
//		this.cid = cid2;
//	}
//	public int getCsid() {
//		return cid;
//		
//	}
	public void removeCourse(int cid) throws SQLException {
		Course_DAO cl = new Course_DAO();
		cl.removeCourse(cid);
		
		
	}

} 

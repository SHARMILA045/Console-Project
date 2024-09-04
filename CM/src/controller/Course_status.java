package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Register_DAO;

public class Course_status {
   private String sregno;
   private String cname;
   private String cstatus;
   private int cid;
		public Course_status(String sregno, String cname, String cstatus,int cid) {
			this.sregno = sregno;
			this.cname = cname;
			this.cstatus = cstatus;
			this.cid = cid;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public Course_status() {
			// TODO Auto-generated constructor stub
		}
		public String getSregno() {
			return sregno;
		}
		public void setSregno(String sregno) {
			this.sregno = sregno;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
			
		}
		public String getCstatus() {
			return cstatus;
		}
		public String setCstatus(String cstatus) {
			return this.cstatus = cstatus;
		}
		public static int regCour(Course_status cd) throws SQLException {
			int n = Register_DAO.registerCourse(cd);
			return n;
		}
		public static ArrayList<Course_status> myCourse(Course_status my) throws SQLException {
			 ArrayList<Course_status> ac1 = Register_DAO.viewMyCourse(my);
			return ac1;
			
		}
		public static void completeCourse(Course_status fin) throws SQLException {
			Register_DAO.completeCourse(fin);
			
		}
		
}


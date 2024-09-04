package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controller.CourseList;

public class Course_DAO {

	public static ArrayList<CourseList> dbViewCourse() throws SQLException {
		Connection con = Db_Connection.getConnection();
		ArrayList<CourseList> ac = new ArrayList<>();
		String query = "SELECT * FROM course";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			CourseList cl = new CourseList();
			int cid = rs.getInt("course_id");
			String cname = rs.getString("course_name");
			String domain = rs.getString("domain");
			int mod = rs.getInt("modules");
			
			cl.setCid(cid);
		    cl.setCname(cname);
		    cl.setDomain(domain);
		    cl.setModules(mod);
		    ac.add(cl);
		}
		return ac;
	}

	public static void addCourse(CourseList cl) throws SQLException {
		Connection con = Db_Connection.getConnection();
		String query = "INSERT INTO COURSE (course_id, course_name, domain, modules) VALUES(?,?,?,?)";
		PreparedStatement ps  =con.prepareStatement(query);
		ps.setInt(1, cl.getCid());
		ps.setString(2, cl.getCname());
		ps.setString(3,  cl.getDomain());
		ps.setInt(4, cl.getModules());
		ps.executeUpdate();
		
		
	}

	public void removeCourse(int cid) throws SQLException {
		int n = cid;
		Connection con = Db_Connection.getConnection();
		String query = "DELETE FROM COURSE WHERE course_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, n);
		ps.executeUpdate();
		
	}

}

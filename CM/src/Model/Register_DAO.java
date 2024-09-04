package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.CourseList;
import controller.Course_status;

public class Register_DAO {

    public static int registerCourse(Course_status cd) throws SQLException {
        Connection con = Db_Connection.getConnection();
        String query = "SELECT course_id FROM course WHERE course_name = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, cd.getCname());
        ResultSet rs = pst.executeQuery();
        Course_status csts = new Course_status();
        String sroll = cd.getSregno();
        while (rs.next()) {
            int cid = rs.getInt("course_id");
            csts.setCid(cid);
        }
        int flag = 0;
        if(csts.getCid()==0)
        	flag = 1;
        else {
        csts.setSregno(sroll);
        String query0 = "SELECT register_no FROM course_update WHERE register_no=?";
        PreparedStatement ps1 = con.prepareStatement(query0);
        ps1.setString(1, sroll);
        ResultSet rs1 = ps1.executeQuery();
        String ss = "in-progress";
        String query1 = "INSERT INTO course_update(register_no,course_id,course_status) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query1);
        ps.setString(1, csts.getSregno());
        ps.setInt(2, csts.getCid());
        csts.setCstatus(ss);
        ps.setString(3, csts.getCstatus());
        ps.executeUpdate();
        }
		return flag;
    }

	public static ArrayList<Course_status> viewMyCourse(Course_status my) throws SQLException {
		
		Connection con = Db_Connection.getConnection();
		ArrayList<Course_status> ac = new ArrayList<>();
		String query = "SELECT course_id,course_status,register_no FROM course_update WHERE register_no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, my.getSregno());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Course_status cl = new Course_status();
			String sreg = rs.getString("register_no");
			int cid = rs.getInt("course_id");
			String status = rs.getString("course_status");
			cl.setCid(cid);
		    cl.setCstatus(status);
		    cl.setSregno(sreg);
		    ac.add(cl);
		}
		return ac;
	}

	public static void completeCourse(Course_status fin) throws SQLException {
	    String s = "Completed";
	    Connection con = Db_Connection.getConnection();
	    String query = "UPDATE course_update SET course_status = ? WHERE register_no = ?";
	    PreparedStatement ps = con.prepareStatement(query);
	    ps.setString(1, s);
	    ps.setString(2, fin.getSregno()); 
	    ps.executeUpdate();
	    con.close(); 
	}
}

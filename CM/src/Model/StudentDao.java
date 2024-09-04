package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Student;

public class StudentDao {

	public static Student studentLogin(Student s1) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Db_Connection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT Password,Register_No FROM student WHERE Mail_ID=?");
		ps.setString(1, s1.getMailid());
		ResultSet rs = ps.executeQuery();
		Student st = new Student();
		while(rs.next()) {
			String dbpass = rs.getString("Password");
			String dbroll = rs.getString("Register_No");
			st.setPassword(dbpass);
			st.setRegister_no(dbroll);
		}
		return st;
	}

	public static Student courseView() throws SQLException {
		
		Connection con = Db_Connection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM course");
		return null;
	}
}


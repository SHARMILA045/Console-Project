package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Admin;

public class AdminDao {

	public static Admin adminLogin(Admin a1) throws SQLException {
		Connection con = Db_Connection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT Password FROM admin WHERE Email_ID=?");
		ps.setString(1, a1.getEmail_ID());
		ResultSet rs = ps.executeQuery();
		Admin ad = new Admin();
		while(rs.next()) {
			String dbpass = rs.getString("Password");
			ad.setPassword(dbpass);
		}
		return ad;
	}

}

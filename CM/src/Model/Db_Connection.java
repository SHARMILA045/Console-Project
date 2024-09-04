package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {


		private static Connection con = null;

		static
		{
			String url = "jdbc:mysql:// localhost:3306/course";
			String user = "root";
			String pass = "Siet@1234";
			try {
				con = DriverManager.getConnection(url, user, pass);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static Connection getConnection()
		{
			return con;
		}
	}
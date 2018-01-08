package ers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect
{
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static Connection getConnection() throws SQLException
	{
		String url = "jdbc:oracle:thin:@jta1712-csu007.cocv7xs40fhs.us-east-2.rds.amazonaws.com:1521:ORCL";
		String usr = "csu007";
		String psswrd = "csu007";
		
		loadDrivers();
		
		return DriverManager.getConnection(url, usr, psswrd);	
		
	}
	
	public static void main(String[]args)
	{
		String url = "jdbc:oracle:thin:@jta1712-csu007.cocv7xs40fhs.us-east-2.rds.amazonaws.com:1521:ORCL";
		String usr = "csu007";
		String psswrd = "csu007";
		loadDrivers();
		jdbcExample(url, usr, psswrd);
	}
	
	static void loadDrivers()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	static void jdbcExample(String url, String user, String password) {
		try {
			conn = DriverManager.getConnection(url, user, password); //2
			stmt = conn.createStatement();		//3
			rs = stmt.executeQuery("select * from Employee");	//4, 5
			while (rs.next()) {
				System.out.println(rs.getString(1) + " : " +  
						rs.getString(2) + " : " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



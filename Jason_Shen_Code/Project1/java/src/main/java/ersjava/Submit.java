package ersjava;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


//API found here: 
//https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/http/HttpServlet.html

public class Submit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 950739352141989143L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
//		PrintWriter out = res.getWriter();
		try {
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String endpointURL = "jdbc:oracle:thin:@shendb.cggugjc0eoa7.us-east-1.rds.amazonaws.com:1521:ORCL";
			String dbuser = "ersjason";
			String dbpass = "p4ssw0rd";
			Connection conn = DriverManager.getConnection(endpointURL, dbuser, dbpass);
			PreparedStatement stmt = conn.prepareStatement("insert into employee (firstname, lastname, emailaddress) values (?,?,?)");
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, email);
			int status_code = stmt.executeUpdate();
			if (status_code != 0) {
				System.out.println("Employee added!");
			}
			else {
				System.out.println("Failed to add employe...");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAO;
import dao.UserDaoImpl;

/**
 * Servlet implementation class ViewInfoServlet
 */
public class ViewInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("asdfasdf").append(request.getContextPath());
		User a = null;
		UserDAO u = null;
		u = new UserDaoImpl();
		String uname = (String) this.getServletConfig().getServletContext().getAttribute("SharedName");

		try
		{
			a = u.getUser(uname);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body><h1>Your information</h1> <p>");
		pw.println("<ul>");
			pw.println("<li>EmployeeId: "); pw.println(a.getEid() + "</li>");
			pw.println("<li>UserName: "); pw.println(a.getUsername() + "</li>");
			pw.println("<li>Password: "); pw.println(a.getPassword() + "</li>");
			pw.println("<li>Name: "); pw.println(a.getFirstname() + " " + a.getLastname() + "</li>");
		pw.println("</ul>");
		pw.println("<form action=\"UpdateInfo.html\">\r\n" + 
				"			<input type=\"submit\" value=\"Update your information\" />\r\n" + 
				"		</form>");
		pw.println("</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAO;
import dao.UserDaoImpl;

/**
 * Servlet implementation class FrontController
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");

		UserDAO u = null;
		u = new UserDaoImpl(); ;
		User a = null;
		try
		{
			a = u.getUser(username);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(a == null)
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html> <body> <p> Username/Password combination does not match</p></body></html>");
		}
		else if (!a.getPassword().equals(password))
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html> <body> <p> "
					+ "Username/Password combination does not match "
					+ "***</p></body></html>");
		}
		else
		{
			ServletContext sharedName = getServletConfig().getServletContext();
			sharedName.setAttribute("SharedName", username);
			ServletContext sharedId = getServletConfig().getServletContext();
			sharedId.setAttribute("SharedId", a.getEid());
			ServletContext isManager = getServletConfig().getServletContext();
			isManager.setAttribute("isManager", a.getIsManager());
			
			if(a.getIsManager().equals("YES"))
			{
				response.sendRedirect("Manager.html");
			}
			else
			{
				response.sendRedirect("Employee.html");
			}
		}
	}

	/**
	 * @ee HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

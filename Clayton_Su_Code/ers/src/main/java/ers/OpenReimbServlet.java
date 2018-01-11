package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.ReimbOpenDAO;
import dao.ReimbOpenDAOImpl;
import dao.UserDAO;
import dao.UserDaoImpl;

/**
 * Servlet implementation class OpenReimbServlet
 */
public class OpenReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenReimbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("sfsfas");
		String stringuserid = request.getParameter("eid");
		String password = request.getParameter("pword");
		String money = request.getParameter("amount");
		String isManager = (String)  this.getServletConfig().getServletContext().getAttribute("isManager");
		int userid = Integer.parseInt(stringuserid);
		UserDAO u = null;
		u = new UserDaoImpl(); ;
		User a = null;
		try
		{
			a = u.getUser(userid);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!a.getPassword().equals(password))
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html> <body> <p> Username/Password "
					+ "combination does not match ***</p></body></html>");
		}
		else
		{
//			response.setContentType("text/html");
//			PrintWriter pw = response.getWriter();
//			pw.println("yes");
			ReimbOpenDAO rod = new ReimbOpenDAOImpl();
			try
			{
				rod.insertReimb(money, stringuserid);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(isManager.equals("YES"))
		{
			response.sendRedirect("Manager.html");
		}
		else
		{
			response.sendRedirect("Employee.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

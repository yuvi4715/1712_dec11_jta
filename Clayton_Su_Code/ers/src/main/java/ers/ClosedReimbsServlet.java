package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReimbClosed;
import dao.ReimbClosedDAO;
import dao.ReimbClosedDAOImpl;

/**
 * Servlet implementation class ClosedReimbsServlet
 */
public class ClosedReimbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClosedReimbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<ReimbClosed> ro = null;
		ReimbClosedDAO rodao = new ReimbClosedDAOImpl();
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try
		{
			ro = rodao.getAllClosedReimb();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.println("<html> <body> <p>");
		
		pw.println("<h1>Closed reimbursements</h1>");
		pw.println("<table>");
		pw.println("<tr>");
			pw.println("<th>IdNo.</th>");
			pw.println("<th>Amount</th>");
			pw.println("<th>Status</th>");
			pw.println("<th>ManagerId</th>");
		pw.println("</tr>");
		
		for(ReimbClosed i: ro)
		{	
			pw.println("<tr>");
			pw.println("<td>" + i.getRidC() +"</td>");
			pw.println("<td>" + i.getAmount() +"</td>");
			pw.println("<td>" + i.getStatus() +"</td>");
			pw.println("<td>" + i.getMid() +"</td>");
			
			pw.println("</tr>");
		}
		pw.println("</table>");	
		pw.println("</html> </body> </p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

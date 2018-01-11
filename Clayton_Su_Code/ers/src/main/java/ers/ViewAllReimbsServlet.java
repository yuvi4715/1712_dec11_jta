package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReimbOpen;
import dao.ReimbOpenDAO;
import dao.ReimbOpenDAOImpl;

/**
 * Servlet implementation class ViewAllReimbsServlet
 */
public class ViewAllReimbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllReimbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ReimbOpen> ro = null;
		ReimbOpenDAO rodao = new ReimbOpenDAOImpl();
		
		try
		{
			ro = rodao.getAllOpenReimb();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <body> <p>");
		pw.println("<table>");
		pw.println("<tr>");
			pw.println("<th>Reimbursement Id No.</th>");
			pw.println("<th>Amount</th>");
			pw.println("<th>Employee Id</th>");
		pw.println("</tr>");
		
		for(ReimbOpen i: ro)
		{
			pw.println("<tr>");
			pw.println("<td>" + i.getRidO() +"</td>");
			pw.println("<td>$" + i.getAmount() +"</td>");
			pw.println("<td>" + i.getEid() +"</td>");
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

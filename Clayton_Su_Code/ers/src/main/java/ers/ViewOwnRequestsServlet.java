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
 * Servlet implementation class ViewOwnRequestsServlet
 */
public class ViewOwnRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOwnRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Yellow ywllow").append(request.getContextPath());
		List<ReimbOpen> ro = null;
		ReimbOpenDAO rodao = new ReimbOpenDAOImpl();
		int id = (int) this.getServletConfig().getServletContext().getAttribute("SharedId");
		String idstring = Integer.toString(id);
		
		try
		{
			ro = rodao.getAllOpenReimbById(idstring);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.getServletConfig().getServletContext().getAttribute("SharedName")
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <body> <p>");
		pw.println("<table>");
		pw.println("<tr>");
			pw.println("<th>IdNo.</th>");
			pw.println("<th>Amount</th>");
		pw.println("</tr>");
		
		for(ReimbOpen i: ro)
		{
			pw.println("<tr>");
			pw.println("<td>" + i.getRidO() +"</td>");
			pw.println("<td>" + i.getAmount() +"</td>");
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

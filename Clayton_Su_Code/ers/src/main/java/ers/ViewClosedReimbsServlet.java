package ers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReimbClosed;
import beans.ReimbOpen;
import dao.ReimbClosedDAO;
import dao.ReimbClosedDAOImpl;
import dao.ReimbOpenDAO;
import dao.ReimbOpenDAOImpl;

/**
 * Servlet implementation class ViewClosedReimbsServlet
 */
public class ViewClosedReimbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClosedReimbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: 1112").append(request.getContextPath());
		int id = (int) this.getServletConfig().getServletContext().getAttribute("SharedId");
		String isManager = (String)  this.getServletConfig().getServletContext().getAttribute("isManager");
		List<ReimbClosed> ro = null;
		ReimbClosedDAO rodao = new ReimbClosedDAOImpl();
		List<ReimbOpen> rop = new ArrayList<ReimbOpen>();
		ReimbOpenDAO rodaop = new ReimbOpenDAOImpl();
		String idstring = Integer.toString(id); //should be employee id
		String givenid = "";
		givenid = request.getParameter("givenId").toString();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try
		{
			//first if statement is called for manager side "get reimbs by id"
			//else managers 
			
			if(!givenid.equals(""))
			{
				rop = rodaop.getAllOpenReimbById(givenid);
				ro = rodao.getAllClosedReimbById(givenid);
			}
			else if(isManager.equals("YES"))
			{
				ro = rodao.getAllClosedReimb();
			}
			else
			{
				ro = rodao.getAllClosedReimbById(idstring);
			}
			//ro = rodao.getAllClosedReimbById(idstring);

			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.getServletConfig().getServletContext().getAttribute("SharedName")
		
		
		
		pw.println("<html> <body> <p>");
		if(ro.isEmpty())
		{
			pw.println("Empty!");
		}
		
		if(!rop.isEmpty())
		{
			pw.println("<h1>Pending reimbursements</h1>");
			pw.println("<table>");
			pw.println("<tr>");
				pw.println("<th>IdNo.</th>");
				pw.println("<th>Amount</th>");				
				pw.println("<th>Employee Id</th>");				
			pw.println("</tr>");
			
			for(ReimbOpen i: rop)
			{	
				pw.println("<tr>");
				pw.println("<td>" + i.getRidO() +"</td>");
				pw.println("<td>" + i.getAmount() +"</td>");
				pw.println("<td>" + i.getEid() +"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");	
		}
		
		pw.println("<h1>Closed reimbursements</h1>");
		pw.println("<table>");
		pw.println("<tr>");
			pw.println("<th>IdNo.</th>");
			pw.println("<th>Amount</th>");
			pw.println("<th>Status</th>");
			if(isManager.equals("YES"))
			{
				pw.println("<th>ManagerId</th>");

			}
		pw.println("</tr>");
		
		for(ReimbClosed i: ro)
		{	
			pw.println("<tr>");
			pw.println("<td>" + i.getRidC() +"</td>");
			pw.println("<td>" + i.getAmount() +"</td>");
			pw.println("<td>" + i.getStatus() +"</td>");
			//pw.println("<td>" + i.getEid() +"</td>");
			if(isManager.equals("YES"))
			{
				pw.println("<td>" + i.getMid() +"</td>");
			}
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

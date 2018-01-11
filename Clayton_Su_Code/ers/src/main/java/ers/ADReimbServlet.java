package ers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReimbOpen;
import dao.ReimbClosedDAO;
import dao.ReimbClosedDAOImpl;
import dao.ReimbOpenDAO;
import dao.ReimbOpenDAOImpl;

/**
 * Servlet implementation class ADReimbServlet
 */
public class ADReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADReimbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("sdfasdfasdfads").append(request.getContextPath());
		String approved = request.getParameter("approved");
		int manager_id = (int) this.getServletConfig().getServletContext().getAttribute("SharedId");
		//get this id because you have to be logged in to approve
		int approved_int = Integer.parseInt(approved);
		
		List<ReimbOpen> ro = null;
		ReimbOpenDAO rodao = new ReimbOpenDAOImpl();
		ReimbClosedDAO rodaoc = new ReimbClosedDAOImpl();
		
		try
		{
			ro = rodao.getAllOpenReimb();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ReimbOpen i: ro)
		{
			if(i.getRidO() == approved_int)
			{
				try
				{
					rodaoc.insertReimb(i.getAmount(), i.getEid(), manager_id, "APPROVED");
					rodao.deleteReimb(i.getRidO());
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		response.sendRedirect("Manager.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

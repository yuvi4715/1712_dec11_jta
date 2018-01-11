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
 * Servlet implementation class ADReimbServlet2
 */
public class ADReimbServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADReimbServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String denied = request.getParameter("denied");
		int manager_id = (int) this.getServletConfig().getServletContext().getAttribute("SharedId");
		//get this id because you have to be logged in to approve
		int denied_int = Integer.parseInt(denied);
		
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
			if(i.getRidO() == denied_int)
			{
				try
				{
					rodaoc.insertReimb(i.getAmount(), i.getEid(), manager_id, "DENIED");
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

package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimbursements;
import com.revature.connection.ConnectionFactory;
import com.revature.dao.ReimbursementDAO;
import com.revature.utils.ConstantStrings;

@WebServlet("/ResolvedReimbursements")
public class ResolvedReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();
	
	String closedPage = new ConstantStrings().getClosedPage();
       
    public ResolvedReimbursementsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reimbursements> closedList = null;
		List<Reimbursements> closedEList = null;
		
		Connection con = null;
		
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);

			String empTitle = (String)req.getSession().getAttribute("employeeTitle");
			String empUser = (String)req.getSession().getAttribute("employeeUsername");
			
			// if user is an employee only, can only view his/her reimbursements
			// if user is a manager, can view ALL reimbursements
			closedList = new ReimbursementDAO().closedList(con);
			closedEList = new ReimbursementDAO().closedEList(empUser, con);
			
			if (empTitle.equalsIgnoreCase("Manager")) {
				req.setAttribute("closedList", closedList);	
			} else {
				req.setAttribute("closedList", closedEList);
			}
			
//			// send the list with attributes to the HTML
//			req.setAttribute("closedList", closedList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher(closedPage).forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}

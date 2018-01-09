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

@WebServlet("/OpenReimbursements")
public class OpenReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();
	
	String openPage = new ConstantStrings().getOpenPage();
	String openEPage = new ConstantStrings().getOpenEPage();
       
    public OpenReimbursementsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursements> openList = null;
		List<Reimbursements> openEList = null;
		
		Connection con = null;
		
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			

			String empTitle = (String)req.getSession().getAttribute("employeeTitle");
			String empUser = (String)req.getSession().getAttribute("employeeUsername");

			// if user is an employee only, can only view his/her reimbursements
			// if user is a manager, can view ALL reimbursements
			openList = new ReimbursementDAO().openList(con);
			openEList = new ReimbursementDAO().openEList(empUser, con);
			
			// send the list with attributes to the HTML
			if (empTitle.equalsIgnoreCase("Manager")) {
				req.setAttribute("openList", openList);	
			} else {
				req.setAttribute("openList", openEList);
			}

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
			
			String empTitle = (String)req.getSession().getAttribute("employeeTitle");
			String empUser = (String)req.getSession().getAttribute("employeeUsername");
			
			if (empTitle.equalsIgnoreCase("Manager")) {
				req.getRequestDispatcher(openPage).forward(req, resp);
			} else {
				req.getRequestDispatcher(openEPage).forward(req, resp);
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
	}

}

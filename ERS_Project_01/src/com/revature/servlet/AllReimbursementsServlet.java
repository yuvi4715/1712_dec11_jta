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

@WebServlet("/AllReimbursements")
public class AllReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();
	
	String closedPage = new ConstantStrings().getClosedPage();
    
    public AllReimbursementsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Reimbursements> closedList = null;
		
		Connection con = null;
		
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			
			// if user is an employee only, can only view his/her reimbursements
			// if user is a manager, can view ALL reimbursements
			closedList = new ReimbursementDAO().rList(con);
			
			// send the list with attributes to the HTML
			request.setAttribute("closedList", closedList);
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
			request.getRequestDispatcher(closedPage).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


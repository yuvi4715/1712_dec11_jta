package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimbursements;
import com.revature.connection.ConnectionFactory;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.utils.ConstantStrings;

@WebServlet("/NewReimbursements")
public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String connectionUser = new ConstantStrings().getConnectionUser();
	String connectionPass = new ConstantStrings().getConnectionPass();

	String newReimbursementPage = new ConstantStrings().getNewReimbursementPage();
    
    public NewReimbursementServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("employeeUsername");	// username - used to get other info
		String amt = request.getParameter("empAmount");									// amount
		String desc = request.getParameter("rDesc");									// description

		Connection con = null;
		
		try {
			con = ConnectionFactory.getInstance().getConnection(connectionUser, connectionPass);
			
			int empID = new EmployeeDAO().getEmpID(user, con);							// employeeID
			Reimbursements r = new Reimbursements(empID, Integer.parseInt(amt), desc);
			
			ReimbursementDAO rd = new ReimbursementDAO();
			
			rd.newReimbursement(r, con);

			// Success Message
			request.setAttribute("typeMessage", "alert alert-success");
			request.setAttribute("message", "Successful Registered!");
		} catch (Exception e) {
			
			// Fail Message
			request.setAttribute("typeMessage", "alert alert-danger");
			request.setAttribute("message", "Failed To Create Reimbursement");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		request.getRequestDispatcher(newReimbursementPage).include(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}

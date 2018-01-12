package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;

/**
 * Servlet implementation class Logout
 */


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Logout Servlet entered");
		Employee loggedOut = (Employee) request.getSession().getAttribute("loggedEmployee");
		//System.out.println("Logging out " + loggedOut.getUsername());
		
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		    //System.out.println("Session exists; clearing session");
		}
		//System.out.println("Done clearing session");
		
		//Employee logOutCheck = (Employee) request.getSession().getAttribute("employee");
		////System.out.println("Should be null: " + logOutCheck.getUsername());
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}



}

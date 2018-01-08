package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.DAOFactory;
import com.revature.model.Credential;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		try {
//			ObjectMapper om = new ObjectMapper();
//			Credential cred = om.readValue(request.getInputStream(), Credential.class);
//			System.out.println(cred.toString());
//			if(DAOFactory.getInstance().validate("rpierre", "rpierre1")) {
//				response.getWriter().append("This login is valid");
//			}
//			else
//				response.getWriter().append("This login is not valid");
//			//PrintWriter pw= response.getWriter();
//			//ArrayList rl = DAOFactory.getInstance().getReimbursements(1, "pending");
////			for(Object reimbursement : rl)
////				pw.println(reimbursement.toString());
//			//pw.println(DAOFactory.getInstance().getEmployeeInfo("rpierre"));
//			//response.getWriter().append("Served at: ").append(request.getContextPath());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NullPointerException e) {
//			System.out.println("The resultSet is empty");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			ObjectMapper om = new ObjectMapper();
			String theread = request.getReader().readLine();
			
			System.out.println(theread);
			Credential cred = om.readValue(theread, Credential.class);
			System.out.println(cred);
			
//			Credential cred = om.readValue(request.getReader().toString(), Credential.class);
			
			//Credential cred = om.readValue(request.getInputStream(), Credential.class);
			//System.out.println(cred.toString());
			if(DAOFactory.getInstance().validate(cred.getUsername(), cred.getPassword())) {
				response.getWriter().append("This login is valid");
			}
			else
				response.getWriter().append("This login is not valid");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (NullPointerException e) {
			System.out.println("The resultSet is empty");
		}
		//response.getWriter().write( new ObjectMapper().writeValueAsString(DAOFactory.getInstance().validate(user, "something")));
//		if(DAOFactory.getInstance().validate("rpierre", "rpierre1")) {
//			response.getWriter().append("This login is valid");
//		}
//		else
//			response.getWriter().append("This login is not valid");
//		} catch(SQLException e) {
//			e.printStackTrace();
	}

}

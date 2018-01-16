package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//@WebServlet(description = "Initially handles all requests", urlPatterns = { "/TransferServlet", "*.do" })
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TransferServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher((String)Dispatcher.send(request, response)).include(request, response);
		

	}




}

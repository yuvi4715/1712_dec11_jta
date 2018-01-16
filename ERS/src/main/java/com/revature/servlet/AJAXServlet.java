package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class AJAXServlet
 */
//@WebServlet(
//		asyncSupported = true, 
//		urlPatterns = { 
//				"/AJAXServlet", 
//				"*.AJAX"
//		})
public class AJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //Move this to "TransferController to make the front controller design
    public AJAXServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(Dispatcher.send(request, response)));
	}


}

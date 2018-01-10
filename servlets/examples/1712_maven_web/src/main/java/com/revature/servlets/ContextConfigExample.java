package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextConfigExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextConfigExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext sc1 = getServletContext();
		String str1 = sc1.getInitParameter("QuarterBack");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>"
				+ "<p> Current week best quarter back is : "+  str1 + "</p>");
		
		ServletConfig sc2 = getServletConfig();
		String str2 = sc2.getInitParameter("WideReceiver");
		pw.println("<p> Current week best wide receiver is : "+  str2 + "</p>");
				
		String str3 = (String) sc1.getAttribute("RunningBack");
		
		pw.println("<p> Current week best running back is : "+  str3 + "</p>"
				+ "</body></html>");
		
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

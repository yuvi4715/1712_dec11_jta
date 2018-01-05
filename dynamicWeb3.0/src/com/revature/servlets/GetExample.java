package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getme")
public class GetExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().println("this text is appearing from GetExample servlet");
//		String name = request.getParameter("fullname");
//		PrintWriter pw = response.getWriter();
//		pw.println(name);
	}

}

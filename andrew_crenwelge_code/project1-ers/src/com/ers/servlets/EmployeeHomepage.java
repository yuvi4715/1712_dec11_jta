package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeHomepage")
public class EmployeeHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// somehow send manager data to jsp page
		req.getRequestDispatcher("ManagerHomepage.jsp").forward(req,resp);
	}
}

package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.User;
import com.ers.util.LogUtil;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = -2845915078425757454L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		System.out.println("Logging out user");
		User u1 = (User) req.getSession().getAttribute("user");
		LogUtil.logger.info("User "+u1.getUsername()+" logged out");
		req.getSession().removeAttribute("employee");
		req.getSession().removeAttribute("user");
		req.setAttribute("successMsg", "Successfully logged out");
		req.getRequestDispatcher("login.jsp").forward(req,resp);
	}
}
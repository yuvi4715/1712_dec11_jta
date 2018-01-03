package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Request;

@WebServlet("/DenyRequest")
public class DenyRequest extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the request data somehow
		int reqId = Integer.parseInt(req.getParameter("reqId"));
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = rdao.getRequestById(reqId);
		boolean success = rdao.denyRequest(r);
		if (success) {
			req.setAttribute("successMsg", "Request denied successfully");
		}
		else {
			req.setAttribute("errMsg", "Request was not denied");
		}
		req.getRequestDispatcher("ManagerRequestView.jsp").forward(req,resp);
	}
}
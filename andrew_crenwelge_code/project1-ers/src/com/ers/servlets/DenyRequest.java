package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.util.AjaxObj_reqid;
import com.ers.util.RtnMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/DenyRequest")
public class DenyRequest extends HttpServlet {
	
	private static final long serialVersionUID = 4139060270023748193L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the request data
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        Employee mgr = (Employee) req.getSession().getAttribute("employee");
		ObjectMapper mapper = new ObjectMapper();
        AjaxObj_reqid reqToApprove = mapper.readValue(json, AjaxObj_reqid.class);
		RequestDao rdao = RequestDaoImpl.getInstance();
		Request r = rdao.getRequestById(reqToApprove.getId());
		resp.setContentType("application/json");
		RtnMsg obj = new RtnMsg();
		obj.setSuccessMsg("The request was denied");
		obj.setErrMsg("Sorry, the request was not denied");
		PrintWriter pw = resp.getWriter();
		boolean success = rdao.denyRequest(r,mgr.getId());
		if (success) {
			obj.setSuccess(true);
			pw.println(mapper.writeValueAsString(obj));
		}
		else {
			obj.setSuccess(false);
			pw.println(mapper.writeValueAsString(obj));
		}
	}
}
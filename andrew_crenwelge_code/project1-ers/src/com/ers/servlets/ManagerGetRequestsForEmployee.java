package com.ers.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.RequestDao;
import com.ers.dao.RequestDaoImpl;
import com.ers.model.Request;
import com.ers.model.RequestAjaxObj;
import com.ers.util.AjaxObj_empid;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ManagerGetRequestsForEmployee")
public class ManagerGetRequestsForEmployee extends HttpServlet {
	
	private static final long serialVersionUID = -415521901773532388L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// get the request data
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        // map json to object
		ObjectMapper mapper = new ObjectMapper();
        AjaxObj_empid reqToApprove = mapper.readValue(json, AjaxObj_empid.class);
        // get requests for the employee
		RequestDao rdao = RequestDaoImpl.getInstance();
		List<Request> list = rdao.getRequestsByEmployee(reqToApprove.getId());
		// get the map of employee/manager id's to full names
		Map<Integer,String> mgrMap = rdao.getRequestMgrMap();
		// create the object that will be returned as JSON
		RequestAjaxObj rajo = new RequestAjaxObj();
		rajo.setMap(mgrMap);
		rajo.setRequestobj(list);
		// send json data back
		resp.setContentType("application/json");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(rajo));
		System.out.println("Returning all requests for employee #" +reqToApprove.getId() + ":");
		for (Request r : list) {
			System.out.println(r);
		}
	}
}
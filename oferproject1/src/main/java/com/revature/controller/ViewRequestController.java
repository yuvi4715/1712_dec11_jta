package com.revature.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.revature.model.Request;
import com.revature.service.Service;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/ViewRequestServlet")
//public class ViewRequestController extends HttpServlet {
public class ViewRequestController{
	
	private static final long serialVersionUID = 3826307508494155515L;

	public static String view(HttpServletRequest request) { 
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		
		int mflag = Integer.parseInt((String)session.getAttribute("mflag"));
		int eid = Integer.parseInt((String)session.getAttribute("eid")); // Employee ID of the user
		int eid2=eid;//Initialized with the EID value, later it may recieve 0
		int rid = 0;
		
		String viewtype = request.getParameter("viewtype");
		String approvedeny="";
		
		/*
		 * This servlet is called on multiple occasions:
		 * 1) view all pending requests of the user						viewtype="Pending", eid = (some EID)
		 * 2) view all resolved requests of the user					viewtype="Resolved",eid = (some EID)
		 * 3) view all pending requests of all employees				viewtype="Pending", eid = 0
		 * 4) view all resolved requests of all employees				viewtype="Resolved",eid = 0
		 * 5) view all requests pending/resolved of another employee	viewtype="Other"
		 * 6) Approve/Deny an employees requests
		 */
		
		//ad is the name of the Approve/Deny buttons
		//An Approve button holds the value of its specific Request ID
		//A Deny button holds the char "0" followed by the value of its specific Request ID
		if (request.getParameter("ad") != null)
		{
			approvedeny=request.getParameter("ad");
			if (approvedeny.charAt(0)=='0')
				approvedeny="Denied";
			else
				approvedeny="Approved";
			rid =Integer.parseInt(request.getParameter("ad"));
			Service.getInstance().closeRequest(new Request(rid,eid,approvedeny));
		}
    	
    	if(viewtype.equals("Pending") || viewtype.equals("Resolved"))
    	{
    		eid2=eid;
			request.getSession().setAttribute("person","Your");
    	}
    	if(viewtype.equals("Pending2"))
    	{
    		eid2=0;
    		viewtype="Pending";
			request.getSession().setAttribute("person","All");
    	}
    	if(viewtype.equals("Resolved2"))
    	{
    		eid2=0;
    		viewtype="Resolved";
			request.getSession().setAttribute("person","All");
    	}
    	
			
    	if(!viewtype.equals("Other"))
    	{
		List<Request> requestList = new ArrayList<Request>();
		requestList = Service.getInstance().viewRequests(new Request(eid2,viewtype));
		request.getSession().setAttribute("requestList1",requestList);
    	}
    	else
    	{
    		eid2=Integer.parseInt(request.getParameter("eid3"));
    		List<Request> requestList = new ArrayList<Request>();
    		requestList = Service.getInstance().viewRequests(new Request(eid2,"Pending"));
    		requestList.addAll(Service.getInstance().viewRequests(new Request(eid2,"Resolved")));
    		request.getSession().setAttribute("requestList1",requestList);
    		request.getSession().setAttribute("person","All of Employee ID=");
    		viewtype=Integer.toString(eid2);
    	}
		
    	request.getSession().setAttribute("viewtype",viewtype);	
    	
    	if(mflag==0)
    		return "Employee Homepage.jsp";
	    else if(mflag==1)
    		return "Manager Homepage.jsp";
    	else
    		return "Login.jsp";  
    	
		//request.getRequestDispatcher(destination).forward(request, response);
	}

}

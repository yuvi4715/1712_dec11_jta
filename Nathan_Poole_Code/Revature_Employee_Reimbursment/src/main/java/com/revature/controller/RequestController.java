package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.services.RequestServices;
import com.revature.util.FinalUtil;

public class RequestController {

	public static List<Request> getUserOpenList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listEmployeeOpenRequests(new Employee( (int) Integer.parseInt(request.getParameter("employeeId"))));
	}
	public static List<Request> getUserClosedRequestList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listEmployeeClosedRequests(new Employee( (int) Integer.parseInt(request.getParameter("employeeId"))));
	}
	public static List<Request> getAllOpenList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listAllOpenRequest();
	}
	public static List<Request> getAllClosedList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listAllClosedRequests();
	}
	public static List<Request> getEmployeeOpenList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listUsernameOpenRequests(new Employee( request.getParameter("username")));
	}
	public static List<Request> getEmployeeClosedList(HttpServletRequest request, HttpServletResponse response) {
		return RequestServices.getInstance().listUsernameClosedRequest(new Employee( request.getParameter("username")));
	}
	public static Object submitRequest(HttpServletRequest request, HttpServletResponse response) {
		if(RequestServices.getInstance().submitRequestSecure(
				new Request(
						(int) Integer.parseInt(request.getParameter("employeeId")),
						(double) Double.parseDouble(request.getParameter("ammount")), 
						request.getParameter("desc")))) {
			return new AjaxMessage(FinalUtil.REQUEST_SUBMITED);
		}
		else {
			return new AjaxMessage(FinalUtil.REQUEST_FAIL);
		}
	}
	public static Object finalizeRequest(HttpServletRequest request, HttpServletResponse response) {
		 if(RequestServices.getInstance().finalizeOpenRequest(
				new Request(
						(int)Integer.parseInt(request.getParameter("requestId")),
						request.getParameter("status"),
						request.getParameter("notes"),
						(int) Integer.parseInt(request.getParameter("empid"))
				))){
			 if(request.getParameter("status")=="APPROVED") return new AjaxMessage(FinalUtil.REQUEST_APPROVED);
			 else return new AjaxMessage(FinalUtil.REQUEST_DENIED);
		 }else return new AjaxMessage(FinalUtil.REQUEST_UPDATE_FAIL);
	}
	
}

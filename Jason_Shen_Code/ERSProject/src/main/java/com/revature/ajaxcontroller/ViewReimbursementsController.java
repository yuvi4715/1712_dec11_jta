package com.revature.ajaxcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.service.TicketService;

public class ViewReimbursementsController {
	
	public static Object viewAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return TicketService.getTicketService().getAllTickets(loggedEmployee);		
	}

	public static Object viewAllPending(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return TicketService.getTicketService().getAllPending(loggedEmployee);		
	}

	public static Object viewAllResolved(HttpServletRequest request, HttpServletResponse response) {
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		return TicketService.getTicketService().getAllResolved(loggedEmployee);	
	}
	
}

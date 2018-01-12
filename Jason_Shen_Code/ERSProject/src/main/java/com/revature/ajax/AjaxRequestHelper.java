package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajaxcontroller.ManagerPortalController;
import com.revature.ajaxcontroller.ViewReimbursementsController;
import com.revature.service.TicketService;


/* Request helper specifically for AJAX requests */
public class AjaxRequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERSProject/viewTickets.ajax":
			return ViewReimbursementsController.viewAllReimbursements(request, response);
		case "/ERSProject/viewPending.ajax":
			return ViewReimbursementsController.viewAllPending(request, response);
		case "/ERSProject/viewResolved.ajax":
			return ViewReimbursementsController.viewAllResolved(request, response);
		case "/ERSProject/viewAllEmployees.ajax":
			return ManagerPortalController.viewAllEmployees(request, response);
		case "/ERSProject/viewAllResolved.ajax":
			return ManagerPortalController.viewAllResolved(request, response);
		case "/ERSProject/viewAllPending.ajax":
			return ManagerPortalController.viewAllPending(request, response);
		case "/ERSProject/managerViewPending.ajax":
			return ManagerPortalController.viewPending(request, response);
		case "/ERSProject/approve.ajax":
			return ManagerPortalController.approve(request, response);
		case "/ERSProject/deny.ajax":
			return ManagerPortalController.deny(request, response);
		default:
			return new AjaxMessage("");
		}
	}
}

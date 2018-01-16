package com.revature.ajaxcontroller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Employee;
import com.revature.service.ManagerService;
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

	public static Object viewTicketInfo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entering function viewTicketInfo()");
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		if (loggedEmployee == null) {
			return null;
		}
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			
			String line;
			while ((line = reader.readLine())!=null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			int ticketid = Integer.parseInt(sb.toString());
			return TicketService.getTicketService().getTicketInfo(ticketid);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

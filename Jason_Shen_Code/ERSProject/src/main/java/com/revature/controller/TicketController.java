package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Ticket;
import com.revature.model.TicketLine;
import com.revature.service.TicketLineService;
import com.revature.service.TicketService;

public class TicketController {
	public static String newTicket(HttpServletRequest request) {
		// if manager, return manager home page, else employee home page 
		
		// You should not be able to reach this page if you're not logged in.
		// Checks session for logged user, sends user to login if not logged in.
		Employee loggedEmployee = (Employee) request.getSession().getAttribute("loggedEmployee");
		// GET request means you're coming to the page
		if (loggedEmployee != null && request.getMethod().equals("GET")) {	
			
			// Setting a flag so that you can only submit if you enter the new ticket page
			request.getSession().setAttribute("ticketSubmitting", false);
			return "user/newTicket.jsp";
		}
		// POST request means you've submitted the form
		else if (loggedEmployee != null && request.getMethod().equals("POST")) {
			
			// Prevents you from refreshing the page or doing POST method from anywhere except from the form itself.
			if (request.getSession().getAttribute("ticketSubmitting").equals(true)) {
				return "home.do";
			}								
			request.setAttribute("submitted", true);
			
			String[] categories = request.getParameterValues("category");
			String[] amounts = request.getParameterValues("amount");
			String[] descriptions = request.getParameterValues("description");
			
			// create variable to keep track of total amount for ticket
			double totalAmount = 0.0;
			
			// create new ticket DONE
			Ticket newTicket = new Ticket();
			newTicket.setEmployeeId(loggedEmployee.getId());
			
			// insert ticket to database so that the ticketline foreign keys can reference the ticket primary key
			TicketService.getTicketService().registerTicket(newTicket, loggedEmployee);
			
			// Select newest ticket associated with loggedEmployee to get newest ticketId, which you need to create new line
			Ticket newestTicket = TicketService.getTicketService().getNewestTicket(loggedEmployee);
			
			// Loop through form lines
			for (int i = 0; i < categories.length; i++) {
				System.out.print(loggedEmployee.getId());
				System.out.println("Category: " + categories[i] + ", Amount: " + amounts[i] + ", Description: " + descriptions[i]);

				// Update totalAmount to be used later
				totalAmount += Double.valueOf(amounts[i]);				

				int newestTicketId = newestTicket.getTicketId();
				// Create new line 
				System.out.println(categories[i].toUpperCase());
				TicketLine newTicketLine = new TicketLine(newestTicketId, descriptions[i], Double.valueOf(amounts[i]), categories[i].toUpperCase());
				
				// Link line to ticket
				TicketLineService.getTicketLineService().attach(newTicketLine, newestTicket);
				System.out.println("Linked ticketline to ticket");
			}
			
			// update total of ticket based on lines
			TicketService.getTicketService().updateTotal(newestTicket, totalAmount);
			System.out.println("New ticket and ticketlines added to database!");	
			
			// Sets attribute to true, so if you resend post method or refresh page, it doens't send again.
			// The only way to switch this flag to off is if you enter the create new ticket page
			request.getSession().setAttribute("ticketSubmitting", true);
			return "home.do";
		}

		else {
			// Send to login
			return "user/login.jsp";
		}
	
	}
}

package com.revature.service;

import java.util.List;

import com.revature.dao.TicketDaoJDBC;
import com.revature.model.Employee;
import com.revature.model.Ticket;
import com.revature.model.TicketLine;

public class TicketService {
	// Singleton Stuff
	// ====================================
	private static TicketService ticketService;
	private TicketService() {
		
	}
	public static TicketService getTicketService() {
		if(ticketService == null) {
			ticketService = new TicketService();
		}
		
		return ticketService;
	}
	// ====================================
	public boolean registerTicket(Ticket ticket, Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().add(ticket, employee);
				
	}	
	public Ticket getNewestTicket(Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectNewestTicket(employee);
	}
	public int getNewestTicketId(Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectNewestTicketId(employee);
	}
	public boolean updateTotal(Ticket ticket, double newTotal) {
		return TicketDaoJDBC.getTicketDaoJDBC().updateTotal(ticket, newTotal);
	}
	public List<Ticket> getAllTickets(Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectAll(employee);
	}
	public List<Ticket> getAllPending(Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectPending(employee);
	}
	public Object getAllResolved(Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectResolved(employee);
	}
	public List<TicketLine> getTicketInfo(int ticketid) {
		return TicketDaoJDBC.getTicketDaoJDBC().selectTicketLines(ticketid);
	}
}

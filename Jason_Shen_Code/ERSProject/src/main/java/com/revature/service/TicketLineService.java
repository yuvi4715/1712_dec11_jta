package com.revature.service;

import com.revature.dao.TicketLineDaoJDBC;
import com.revature.model.Ticket;
import com.revature.model.TicketLine;

public class TicketLineService {
	// Singleton Stuff
	// ====================================
	private static TicketLineService ticketLineService;
	private TicketLineService() {
		
	}
	public static TicketLineService getTicketLineService() {
		if(ticketLineService == null) {
			ticketLineService = new TicketLineService();
		}
		
		return ticketLineService;
	}
	// ====================================

	public boolean attach(TicketLine ticketline, Ticket ticket) {
		return TicketLineDaoJDBC.getTicketLineDaoJDBC().link(ticketline, ticket);
	}
	
}

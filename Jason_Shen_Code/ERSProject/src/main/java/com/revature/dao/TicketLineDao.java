package com.revature.dao;

import java.util.List;

import com.revature.model.Ticket;
import com.revature.model.TicketLine;

public interface TicketLineDao {
	public boolean add(TicketLine ticketline);
	public TicketLine select(TicketLine ticketline);
	public List<TicketLine> selectAll();
	public boolean link(TicketLine ticketline, Ticket ticket);
}

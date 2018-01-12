package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Ticket;

public interface TicketDao {
	boolean add(Ticket ticket, Employee employee);
	public Ticket select(Ticket ticket);
	public List<Ticket> selectAll(Employee employee);
	public Ticket selectNewestTicket(Employee employee);
	public int selectNewestTicketId(Employee employee);
	public boolean updateTotal(Ticket ticket, double newTotal);

	
}

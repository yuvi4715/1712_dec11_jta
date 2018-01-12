package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDaoJDBC;
import com.revature.dao.TicketDaoJDBC;
import com.revature.model.Employee;
import com.revature.model.Ticket;

public class ManagerService {
	// Singleton Stuff
	// ====================================
	private static ManagerService managerService;
	private ManagerService() {
		
	}
	public static ManagerService getManagerService() {
		if(managerService == null) {
			managerService = new ManagerService();
		}
		
		return managerService;
	}
	// ====================================
	public boolean makeManager(Employee employee) {
		return EmployeeDaoJDBC.getEmployeeDaoJDBC().setRole(employee, "MANAGER");
	}
	public List<Employee> getAllEmployees() {
		return EmployeeDaoJDBC.getEmployeeDaoJDBC().selectAll();
	}
	public List<Ticket> getAllResolved() {
		return TicketDaoJDBC.getTicketDaoJDBC().selectAllResolved();
	}
	public List<Ticket> getAllPending() {
		return TicketDaoJDBC.getTicketDaoJDBC().selectAllPending();
	}
	public String approve(int ticketid, Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().approve(ticketid, employee);
	}
	public String deny(int ticketid, Employee employee) {
		return TicketDaoJDBC.getTicketDaoJDBC().deny(ticketid, employee);
	}

}

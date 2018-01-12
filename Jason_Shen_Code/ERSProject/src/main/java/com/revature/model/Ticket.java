package com.revature.model;

public class Ticket {
	private int ticketId;
	private int employeeId;
	private int statusId;
	private int resolutionId;
	private double total;
	private String status;
	private String resolution;
	private int resolvedby;
	
	public Ticket(int ticketId, int employeeId, int statusId, int resolutionId, double total) {
		super();
		this.ticketId = ticketId;
		this.employeeId = employeeId;
		this.statusId = statusId;
		this.resolutionId = resolutionId;
		this.total = total;
	}
	
	// When creating blank new ticket, we just know its open and pending and no total yet.
	public Ticket() {
		super();
		this.statusId = 1;
		this.resolutionId = 3;
		this.total = 0.0;
	}

//	public Ticket(int ticketid, int statusid, int resolutionid, double total) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.ticketId = ticketid;
//		this.statusId = statusid;
//		this.resolutionId = resolutionid;
//		this.total = total;
//	}

	public Ticket(int ticketid, int employeeid, String status, String resolution, double total) {
		super();
		this.ticketId = ticketid;
		this.employeeId = employeeid;
		this.status = status;
		this.resolution = resolution;
		this.total = total;
	}
	
	
	public Ticket(int ticketid, int employeeid, String status, String resolution, double total, int resolvedby) {
		// TODO Auto-generated constructor stub
		this.ticketId = ticketid;
		this.employeeId = employeeid;
		this.status = status;
		this.resolution = resolution;
		this.total = total;
		this.resolvedby = resolvedby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(int resolutionId) {
		this.resolutionId = resolutionId;
	}

	public double getTotal() {
		return total;
	}

	public int getResolvedby() {
		return resolvedby;
	}

	public void setResolvedby(int resolvedby) {
		this.resolvedby = resolvedby;
	}

	
	
}

package com.revature.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Reimbursement BEAN */
public class Reimbursement {

	private int ticketId;
	private int employeeId;
	private String status;
	private int total;
	private String submitTime;
	private String closedTime;
	private String description;
	private String category;
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	public Reimbursement() {
		ticketId = 0;
		employeeId = 0;
		status = "";
		total = 0;
		submitTime = "";
		closedTime = "";
		description = "";
		category = "";
	}
	
	public Reimbursement(int ticketId, int employeeId, String status, int total, String submitTime, String closedTime,
			String description, String category) {
		super();
		this.ticketId = ticketId;
		this.employeeId = employeeId;
		this.status = status;
		this.total = total;
		this.submitTime = submitTime;
		this.closedTime = closedTime;
		this.description = description;
		this.category = category;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getSubmitTime() {
		return submitTime;
	}


	public void setSubmitTime() {
		Date time = new Date();
		this.submitTime = df.format(time);
	}


	public String getClosedTime() {
		return closedTime;
	}


	public void setClosedTime(Date closedTime) {
		Date time = new Date();
		this.closedTime = df.format(time);
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategoryId(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Reimbursement [ticketId=" + ticketId + ", employeeId=" + employeeId + ", status=" + status + ", total="
				+ total + ", submitTime=" + submitTime + ", closedTime=" + closedTime + ", description=" + description
				+ ", categoryId=" + category + "]";
	}


}

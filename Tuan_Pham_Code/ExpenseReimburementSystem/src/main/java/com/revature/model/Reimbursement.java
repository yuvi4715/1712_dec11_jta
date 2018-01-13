package com.revature.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Reimbursement BEAN */
public class Reimbursement {

	private int ticketId;
	private int employeeId;
	private String status;
	private int total;
	private Timestamp submitTime;
	private Timestamp closedTime;
	private String description;
	private String category;
	private String resolvedBy;
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	public Reimbursement() {
		
	}
	public Reimbursement(int empId, String category, int total, String description ) {
		this.employeeId = empId;
		this.category = category;
		this.total = total;
		this.description = description;
	}
	
	public Reimbursement(int ticketId, int employeeId, String status, int total, Timestamp submitTime, Timestamp closedTime,
			String description, String category, String resolvedBy) {
		super();
		this.ticketId = ticketId;
		this.employeeId = employeeId;
		this.status = status;
		this.total = total;
		this.submitTime = submitTime;
		this.closedTime = closedTime;
		this.description = description;
		this.category = category;
		this.resolvedBy = resolvedBy;
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
		Date time = new Date();
		return df.format(time);
	}


	public void setSubmitTime(Timestamp submit) {
		Date time = new Date();
		this.submitTime = submit;
	}


	public Timestamp getClosedTime() {
		return closedTime;
	}


	public void setClosedTime(Timestamp closedTime) {
		Date time = new Date();
		this.closedTime = closedTime;
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

	public String getresolvedBy() {
		return resolvedBy;
	}
	
	public void setresolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	@Override
	public String toString() {
		return "Reimbursement [ticketId=" + ticketId + ", employeeId=" + employeeId + ", status=" + status + ", total="
				+ total + ", submitTime=" + submitTime + ", closedTime=" + closedTime + ", description=" + description
				+ ", categoryId=" + category + "]";
	}


}

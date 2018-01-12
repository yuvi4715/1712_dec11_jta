package com.revature.model;

import java.sql.Timestamp;

public class Reimbursement {
	private int reimbursementId; // primary key
	private int employeeId; // foreign key
	private int managerId; // foreign key
	private double amount;
	private String title;
	private String description;
	private Timestamp start;
	private Timestamp end;
	private String status;

	public Reimbursement() {
	}

	public Reimbursement(int employeeId) {
		this.employeeId = employeeId;
	}

	public Reimbursement(int employeeId, double amount, String title, String description) {
		this.employeeId = employeeId;
		this.amount = amount;
		this.title = title;
		this.description = description;
	}

	public Reimbursement(int reimbursementId, int employeeId, int managerId, double amount, String title, String description,
			Timestamp submitDate, Timestamp resolveDate, String status) {
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.amount = amount;
		this.title = title;
		this.description = description;
		this.start = submitDate;
		this.end = resolveDate;
		this.status = status;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getmanagerId() {
		return managerId;
	}

	public void setmanagerId(int managerId) {
		this.managerId = managerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if (amount >= 0) {
			this.amount = amount;
		} else {
			this.amount = 0;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public String getStatus() {
		return status;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", managerId="
				+ managerId + ", amount=" + amount + ", title=" + title + ", description=" + description + ", start="
				+ start + ", end=" + end + ", status=" + status + "]";
	}
}

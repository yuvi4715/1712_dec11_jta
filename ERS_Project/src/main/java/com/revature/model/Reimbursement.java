package com.revature.model;

import java.sql.Date;

public class Reimbursement {
	
	//Auto increment reimbId
	
	private int reimbursementId;
	private int Amount;
	private String status;
	private String description;
	private Date openDate;
	private Date closeDate;
	private int EmployeeId;
	private int ManagerId;
	
	public Reimbursement(int reimbursementId, int amount, String status, String description, Date openDate,
			Date closeDate, int employeeId, int managerId) {
	
		this.reimbursementId = reimbursementId;
		Amount = amount;
		this.status = status;
		this.description = description;
		this.openDate = openDate;
		this.closeDate = closeDate;
		EmployeeId = employeeId;
		ManagerId = managerId;
	}



	public int getReimbursementId() {
		return reimbursementId;
	}



	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}



	public int getAmount() {
		return Amount;
	}



	public void setAmount(int amount) {
		Amount = amount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getOpenDate() {
		return openDate;
	}



	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}



	public Date getCloseDate() {
		return closeDate;
	}



	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}



	public int getEmployeeId() {
		return EmployeeId;
	}



	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}



	public int getManagerId() {
		return ManagerId;
	}



	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	
	

}

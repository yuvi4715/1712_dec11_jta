package com.revature.beans;

public class Reimbursements {

	private int createdBy;
	private int reimbursementID;
	private int amount;
	private String status;
	private String startTime;
	private String endTime;
	private String desc;
	private int handledBy;
	
	// to create a new reimbursement
	public Reimbursements(int createdBy, int amount, String desc) {
		this.createdBy = createdBy;
		this.amount = amount;
		this.desc = desc;
	}

	// for open reimbursement table & newReimbursement
	public Reimbursements(int createdBy, int reimbursementID, int amount, String status, String startTime, String desc) {
		this.createdBy = createdBy;
		this.reimbursementID = reimbursementID;
		this.amount = amount;
		this.status = status;
		this.startTime = startTime;
		this.desc = desc;
	}
	
	// for closed reimbursement table
	public Reimbursements(int createdBy, int reimbursementID, int amount, String status, String startTime, String endTime, String desc, int handledBy) {
		this.createdBy = createdBy;
		this.reimbursementID = reimbursementID;
		this.amount = amount;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.desc = desc;
		this.handledBy = handledBy;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public int getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getDesc() {
		return desc;
	}
	
	public int getHandledBy() {
		return handledBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
	public void setHandledBy(int handledBy) {
		this.handledBy = handledBy;
	}
}

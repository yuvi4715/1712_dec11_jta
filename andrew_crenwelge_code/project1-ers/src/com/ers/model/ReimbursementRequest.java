package com.ers.model;

public class ReimbursementRequest {
	private int reqID;
	private int empID; // foreign key
	private int mgrID; // foreign key
	private String dateSubmitted;
	private boolean isPending;
	private boolean isApproved;
	
	public ReimbursementRequest(int reqID,int empID,int mgrID,String date) {
		this.reqID = reqID;
		this.empID = empID;
		this.mgrID = mgrID;
		this.dateSubmitted = date;
		this.isPending = true;
		this.isApproved = false;
	}
	
	public int getReqID() {
		return reqID;
	}
	public void setReqID(int reqID) {
		this.reqID = reqID;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getMgrID() {
		return mgrID;
	}
	public void setMgrID(int mgrID) {
		this.mgrID = mgrID;
	}
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public boolean isPending() {
		return isPending;
	}
	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}

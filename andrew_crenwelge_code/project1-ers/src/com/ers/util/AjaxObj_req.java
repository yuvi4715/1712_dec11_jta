package com.ers.util;

import java.sql.Timestamp;

public class AjaxObj_req {
	private int reqID;
	private String resolvingMgr;
	private int empID;
	private int mgrID;
	private double amount;
	private String reqTitle;
	private String description;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String status;
	
	// simple constructor for new pending requests
	public AjaxObj_req(int reqID,int empID,int mgrID,Timestamp date) {
		this.reqID = reqID;
		this.empID = empID;
		this.mgrID = mgrID;
		this.dateSubmitted = date;
	}
	
	// full constructor for new resolved requests
	public AjaxObj_req(int reqID,int empID,int mgrID,String title,String status,double amount,Timestamp submitDate,Timestamp resolveDate,String description) {
		this.reqID = reqID;
		this.empID = empID;
		this.mgrID = mgrID;
		this.reqTitle = title;
		this.amount = amount;
		this.status = status;
		this.dateSubmitted = submitDate;
		this.dateResolved = resolveDate;
		this.description = description;
	}
	
	public AjaxObj_req() {}

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
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if (amount > 0)
			this.amount = amount;
		else
			System.err.println("Illegal argument - tried to set amount to negative number");
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateResolved == null) ? 0 : dateResolved.hashCode());
		result = prime * result + ((dateSubmitted == null) ? 0 : dateSubmitted.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + empID;
		result = prime * result + mgrID;
		result = prime * result + reqID;
		result = prime * result + ((reqTitle == null) ? 0 : reqTitle.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AjaxObj_req other = (AjaxObj_req) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateResolved == null) {
			if (other.dateResolved != null)
				return false;
		} else if (!dateResolved.equals(other.dateResolved))
			return false;
		if (dateSubmitted == null) {
			if (other.dateSubmitted != null)
				return false;
		} else if (!dateSubmitted.equals(other.dateSubmitted))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empID != other.empID)
			return false;
		if (mgrID != other.mgrID)
			return false;
		if (reqID != other.reqID)
			return false;
		if (reqTitle == null) {
			if (other.reqTitle != null)
				return false;
		} else if (!reqTitle.equals(other.reqTitle))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [reqID=" + reqID + ", empID=" + empID + ", mgrID=" + mgrID + ", amount=" + amount
				+ ", reqTitle=" + reqTitle + ", description=" + description + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", status=" + status + "]";
	}

	public String getResolvingMgr() {
		return resolvingMgr;
	}

	public void setResolvingMgr(String resolvingMgr) {
		this.resolvingMgr = resolvingMgr;
	}
	
}

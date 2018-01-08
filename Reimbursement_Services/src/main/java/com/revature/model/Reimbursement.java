package com.revature.model;

public class Reimbursement {
	private String firstname;
	private String lastname;
	private int id;
	private String type;
	private String status;
	
	private String reason;
	private java.sql.Date time;
	private int eid;
	
	public Reimbursement(java.sql.Date time, String reason, int eid, String type) {
		this.time = time;
		this.reason = reason;
		this.eid = eid;
		this.type = type;
	}
	public Reimbursement(java.sql.Date time, String reason, String firstname, String lastname) {
		this.time = time;
		this.reason = reason;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Reimbursement() {}
	
	public String toString() {
		return "[id: " + id + ", firstname: " + firstname + ", lastname: " + lastname +", time: " 
				+ time + ", status: " + status + ", reason: " + reason + "]";
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public java.sql.Date getTime() {
		return time;
	}
	public void setTime(java.sql.Date time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}

}

package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reimbursement implements Serializable{
	
	
	private static final long serialVersionUID = 7408850804123057376L;
	private String firstname;
	private String lastname;
	private int id;
	private String type;
	private String status;
	private double amount;
	private String reason;
	private Timestamp time;
	private String managerFirstname;
	private String managerLastname;
	private int eid;
	private int manid;
	
	//For inputting to database
	public Reimbursement(String firstname, String lastname, double amount, String reason, int eid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.amount = amount;
		this.reason = reason;
		this.eid = eid;
	}
	//For creating the table
	public Reimbursement(String firstname, String lastname, int id, String status, double amount, String reason,
			Timestamp time, String managerFirstname, String managerLastname, int eid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.reason = reason;
		this.time = time;
		this.managerFirstname = managerFirstname;
		this.managerLastname = managerLastname;
		this.eid = eid;
	}
	//For retrieving from database
	public Reimbursement(String firstname, String lastname, int id, String type, String status, double amount,
			String reason, Timestamp time, String managerFirstname, String managerLastname, int eid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.reason = reason;
		this.time = time;
		this.managerFirstname = managerFirstname;
		this.managerLastname = managerLastname;
		this.eid = eid;
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
	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getManagerFirstname() {
		return managerFirstname;
	}

	public void setManagerFirstname(String managerFirstname) {
		this.managerFirstname = managerFirstname;
	}

	public String getManagerLastname() {
		return managerLastname;
	}

	public void setManagerLastname(String managerLastname) {
		this.managerLastname = managerLastname;
	}
	public int getManid() {
		return manid;
	}
	public void setManid(int manid) {
		this.manid = manid;
	}

}

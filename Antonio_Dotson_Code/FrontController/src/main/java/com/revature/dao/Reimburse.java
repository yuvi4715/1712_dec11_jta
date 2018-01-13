package com.revature.dao;

public class Reimburse {
	private String lastname;
	private String firstname;
	private String title;
	private int  rid;
	private String description;
	private Double amount;
	private String time;
	private String type;
	private int managerid;
	private String timedate;
	private String resolved_date;
	
	
	public Reimburse(String lastname, String firstname, String title,int rid,String description, Double amount, String time,
			String type, int managerid, String timedate, String resolved_date) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.title = title;
		this.description = description;
		this.rid = rid;
		this.amount = amount;
		this.time = time;
		this.type = type;
		this.managerid = managerid;
		this.timedate = timedate;
		this.resolved_date = resolved_date;
	}
	
	
	public Reimburse() {
		
	}


	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTimedate() {
		return timedate;
	}
	public void setTimedate(String timedate) {
		this.timedate = timedate;
	}
	public String getResolved_date() {
		return resolved_date;
	}
	public void setResolved_date(String resolved_date) {
		this.resolved_date = resolved_date;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

}

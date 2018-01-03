package com.ers.model;

public class User {
	private int empID; // foreign key
	private String username;
	private String passhash;
	private String passSalt;
	
	public User(int empID, String username, String passhash, String passSalt) {
		super();
		this.empID = empID;
		this.username = username;
		this.passhash = passhash;
		this.passSalt = passSalt;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasshash() {
		return passhash;
	}

	public void setPasshash(String passhash) {
		this.passhash = passhash;
	}

	public String getPassSalt() {
		return passSalt;
	}

	public void setPassSalt(String passSalt) {
		this.passSalt = passSalt;
	}
	
}

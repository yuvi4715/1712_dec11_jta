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

	public User() {}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empID;
		result = prime * result + ((passSalt == null) ? 0 : passSalt.hashCode());
		result = prime * result + ((passhash == null) ? 0 : passhash.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (empID != other.empID)
			return false;
		if (passSalt == null) {
			if (other.passSalt != null)
				return false;
		} else if (!passSalt.equals(other.passSalt))
			return false;
		if (passhash == null) {
			if (other.passhash != null)
				return false;
		} else if (!passhash.equals(other.passhash))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [empID=" + empID + ", username=" + username + ", passhash=" + passhash + ", passSalt=" + passSalt
				+ "]";
	}
	
	
}

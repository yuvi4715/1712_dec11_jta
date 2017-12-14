package com.revature.as1.fileio;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String role;
	
	public Employee() {
		this.employeeID = 0;
		this.firstName = null;
		this.lastName = null;
		this.role = null;
	}
	
	public Employee(int employeeID, String firstName, String lastName, String role) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
	public String toString() {
		return "Employee ID: " + employeeID + " Name: " + firstName + " " + lastName + " Role: " + role;
	}
	
	
	
}

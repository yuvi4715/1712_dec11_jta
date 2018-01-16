package com.revature.model;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private int reportsTo;
	private String username;
	private String password;
	private String title;
	private String email;

	public Employee(int employeeId, String firstName, String lastName, String title, int reportsTo, String email, String username,
			String password) {
		
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.reportsTo = reportsTo;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", reportsTo=" + reportsTo + ", username=" + username + ", password=" + password + ", title=" + title
				+ ", email=" + email + "]";
	}
	

	
	
	
	

}

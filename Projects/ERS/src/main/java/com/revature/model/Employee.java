package com.revature.model;

/* Main Employee POJO (bean) needed for example */
public class Employee {
	private int employeeId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String logStatus;
	private String title;
	private int roleId;
	private String email;	
	private String position;
	
	public Employee() {
		this.firstName = "";
		this.lastName = "";
	}

	public Employee(int id) {
		this();
		this.employeeId = id;
	}
	
	public Employee(int id, String user) {
		this.username = user;
	}
	
	public Employee(String user) {
		this.username = user;
	}
		
	public Employee(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	public Employee(int id, String user, String pass, String firstname, String lastname) {
		this.username = user;
		this.password = pass;
		this.firstName = firstname;
		this.lastName = lastname;
	}
	
	public Employee(int id, String user, String pass, String first, String last, 
			String log, String title, int role, String email, String pos) {
		this.employeeId = id;
		this.username = user;
		this.password = pass;
		this.firstName = first;
		this.lastName = last;
		this.logStatus = log;
		this.title = title;
		this.roleId = role;
		this.email = email;
		this.position = pos;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int id) {
		this.employeeId = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getStatus() {
		return logStatus;
	}
	
	public void setStatus(String logStatus) {
		this.logStatus = logStatus;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", "
				+ "firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

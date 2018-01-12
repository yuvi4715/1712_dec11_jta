package com.revature.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	public Employee( ) {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
	}
	
	public Employee(String email) {
		this();
		this.email = email;
	}
	
	public Employee(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Employee(String email, String password) {
		this();
		this.email = email;
		this.password = password;
	}

	public Employee(int id, String firstname, String lastname, String email, String password) {
		this();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
	}
	public Employee(int id, String firstname, String lastname, String email) {
		this();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}

	public Employee(int id, String firstName, String lastName, String email, String password, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Employee(int id) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

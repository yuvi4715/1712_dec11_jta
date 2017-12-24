package com.ers.model;

public class Employee {
	private int empID;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String birthdate;
	private String email;
	private String phoneNumber;
	private String address;
	private String state;
	private String country;
	private String zip;

	public Employee(int id) {
		super();
		this.empID = id;
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Employee(int id, String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public Employee() {
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.password = "";
	}

	public int getId() {
		return empID;
	}

	public void setId(int id) {
		this.empID = id;
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
	

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Customer [id=" + empID + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}

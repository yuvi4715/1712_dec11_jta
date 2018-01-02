package com.ers.model;

public class Employee {
	private int empID;
	private String firstname;
	private String lastname;
	private String username;
	private Boolean isManager;
	private String passhash;
	private String passSalt;
	private String birthdate;
	private String email;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;

	public Employee(int id) {
		super();
		this.empID = id;
	}

	public Employee(String username, String passhash) {
		super();
		this.username = username;
		this.passhash = passhash;
	}

	public Employee(int id, String firstname, String lastname, String username, String passhash) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.passhash = passhash;
	}

	public Employee() {
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.passhash = "";
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

	public String getpasshash() {
		return passhash;
	}

	public void setpasshash(String passhash) {
		this.passhash = passhash;
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
				+ ", passhash=" + passhash + "]";
	}

	public String getPassSalt() {
		return passSalt;
	}

	public void setPassSalt(String passSalt) {
		this.passSalt = passSalt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	
	
}

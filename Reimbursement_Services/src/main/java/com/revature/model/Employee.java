package com.revature.model;

public class Employee {

	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private long phone;
	private String email;
	private String title;
	
	public Employee(String firstname, String lastname, String address, String city, String state, int zipCode,
			long phone, String email, String title) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
		this.title = title;
	}
	
	public Employee() {}
	
	public String toString() {
		return "[firstname: " + firstname + ", lastname: " + lastname
				+ ", address: " + address + ", city: " + city
				+ ", state: " + state + ", zipcode: " + zipCode
				+ ", phone: " + phone + ", email: " + email
				+ ", title: " + title + "]";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}

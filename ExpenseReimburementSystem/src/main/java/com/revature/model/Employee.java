package com.revature.model;

/* Employee BEAN */
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String emailAddress;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	
	public Employee() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
		this.emailAddress = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.phone = "";
	}

	public Employee(int id) {
		this();
		this.id = id;
	}
	
	public Employee(String username) {
		this();
		this.username = username;
	}
	
	public Employee(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public Employee(int id, String firstName, String lastName, String emailAddress, String address, String city, String state, 
			String zip, String phone, String username, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.username = username;
		this.password = password;
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
	
	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
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
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
}

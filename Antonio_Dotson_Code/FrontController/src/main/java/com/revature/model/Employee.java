package com.revature.model;

/* Main Customer POJO (bean) needed for example */
public class Employee {
	private int id;
	private int eid;
	private String lastName;
	private String firstName;
	private String title;
	private int managerid;
	private String birthdate;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	private String username;
	private String password;
	
	public Employee() {
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
	}
	
	public Employee(String username) {
		this();
		this.username = username;
	}
   
	
	public Employee(int eid) {
		this();
		this.id = eid;
	}
	
	public Employee(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public Employee(String username,String password,int eid) {
		this();
		this.username = username;
		this.password = password;
		this.eid = eid;
	}
	
	public Employee(String lastName, String firstName, String title, int managerid, String birthdate,
			String address, String city, String state, String phone, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.managerid = managerid;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		
	}
	
	public Employee(int id, int eid, String lastName, String firstName, String title, int managerid, String birthdate,
			String address, String city, String state, String phone, String email) {
		this.id = id;
		this.eid = eid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.managerid = managerid;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
	}
	
	public Employee(String lastName, String firstName, String title,String address, String city, String state, String phone, 
			String email,int eid) { 
		this.eid = eid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.eid = eid;
	}
	
	public Employee(int id, int eid, String lastName, String firstName, String title, int managerid, String birthdate,
			String address, String city, String state, String phone, String email, String username, String password) {
		this.id = id;
		this.eid = eid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.managerid = managerid;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
}





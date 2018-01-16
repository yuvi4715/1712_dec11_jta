package com.revature.reimbursement;

public class Employee {
	private int eid;
	private String firstname;
	private String lastname;
	private String email;
	private String roleid;
	private String title;
	
	public Employee(int eid){
		super();
		this.eid = eid;
	}
	
	public Employee(int eid, String firstname, String lastname, String email, String roleid, String title) {
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleid = roleid;
		this.title = title;
	}
	
	
	public Employee() {
		this.eid = 0;
		this.firstname = "";
		this.lastname = "";
		this.email = "";
		this.roleid = "";
		this.title = "";	
	}
	
	// Eid
	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	//first name
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	//lastname
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//roleid
	public String getRoleid() {
		return roleid;
	}
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	//title
	public String getTitle() {
		return title;
	}
	
	public void setTitle() {
		this.title = title;
	}

}

package com.revature.beans;

// Employee Bean
public class Employee {

	//Employee_Tbl Variables
	private int emp_id;
	private String emp_fname;
	private String emp_lname;
	private String emp_email;
	private String emp_role;
	private String emp_title;
	private int emp_reportsTo;

	// User_Tbl Variables
	private String log_status;
	private String username;
	private String password;
	
	// default
	public Employee() {
	}
	
	// addEmployee() - EmployeeDAO.java
	public Employee(String fname, String lname, String email, String username, String password, String role, String title,
			int reportsTo) {
		this.emp_fname = fname;
		this.emp_lname = lname;
		this.emp_email = email;
		this.username = username;
		this.password = password;
		this.emp_role = role;
		this.emp_title = title;
		this.emp_reportsTo = reportsTo;
	}

	// used when getting the list of all the employees
	public Employee(int emp_id, String emp_fname, String emp_lname, String emp_email, String emp_role,
			String emp_title, int emp_reportsTo) {
		this.emp_id = emp_id;
		this.emp_fname = emp_fname;
		this.emp_lname = emp_lname;
		this.emp_email = emp_email;
		this.emp_role = emp_role;
		this.emp_title = emp_title;
		this.emp_reportsTo = emp_reportsTo;
	}

	// createUser() - EmployeeDAO.java AND login - UserServlet.java
	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// used to get employee info to display in Manager Homepage
	public Employee(int emp_id, String emp_fname, String emp_lname, String emp_email, String emp_role,
			int emp_reportsTo, String username) {
		this.emp_id = emp_id;
		this.emp_fname = emp_fname;
		this.emp_lname = emp_lname;
		this.emp_email = emp_email;
		this.emp_role = emp_role;
		this.emp_reportsTo = emp_reportsTo;
		this.username = username;
	}

	// updateEmployee - EmployeeDAO().java
	public Employee(int emp_id, String emp_email, String username, String password, String emp_role, int emp_reportsTo) {
		this.emp_id = emp_id;
		this.emp_email = emp_email;
		this.username = username;
		this.password = password;
		this.emp_role = emp_role;
		this.emp_reportsTo = emp_reportsTo;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public String getEmp_lname() {
		return emp_lname;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public String getEmp_title() {
		return emp_title;
	}
	
	public int getEmp_reportsTo() {
		return emp_reportsTo;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}

	public void setEmp_reportsTo(int emp_reportsTo) {
		this.emp_reportsTo = emp_reportsTo;
	}

	public String getLog_status() {
		return log_status;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setLog_status(String log_status) {
		this.log_status = log_status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

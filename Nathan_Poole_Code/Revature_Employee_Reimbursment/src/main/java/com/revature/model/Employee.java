package com.revature.model;

public class Employee {

	private int employeeId = 0;
	private String employeeName;
	private String email;
	private String username = "";
	private String pw = "";
	private String titleType;
	private int managerState;
	
	public Employee() {};
	
	public Employee(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Employee(String username) {
		this.username = username;
	}
	
	public Employee(String username, String pw) {
		super();
		this.username = username;
		this.pw = pw;
	}
	
	public Employee(int employeeId, String employeeName, String email, String username, String pw) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.username = username;
		this.pw = pw;
	}
	
	public Employee(String employeeName, String email, String username, String pw, String titleType, int managerState) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.username = username;
		this.pw = pw;
		this.titleType = titleType;
		this.managerState = managerState;
	}
	
	public Employee(int employeeId, String employeeName, String email, String username, String pw,
			String titleType, int managerState) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.username = username;
		this.pw = pw;
		this.titleType = titleType;
		this.managerState = managerState;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public int getManagerState() {
		return managerState;
	}

	public void setManagerState(int managerState) {
		this.managerState = managerState;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", username=" + username + ", pw=" + pw + ", titleType=" + titleType
				+ ", managerState=" + managerState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + managerState;
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((titleType == null) ? 0 : titleType.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (managerState != other.managerState)
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (titleType == null) {
			if (other.titleType != null)
				return false;
		} else if (!titleType.equals(other.titleType))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
	
	
}

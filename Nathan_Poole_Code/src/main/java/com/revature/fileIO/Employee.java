package com.revature.fileIO;

/* 
 * Nathan Poole 
 * Question Twenty four to Twenty Eight
 * Consider a text file has the following colon-separated lines:
 * 
 * Employee id:First Name:Last Name:Role
 * 
 * Read the file, and parse(tokenize) the fields using StringTokenizer with 
 * 		delimiter(:)
 * 
 * While parsing the file, place the information in an object, which should 
 * 		have four instance variables: Employee Id, First Name, Last Name, Role. 
 * 
 * Place these objects in a HashMap with the key as employee id and value as 
 * 		the object
 * 		i.e HashMap should have
 * 			Key: 01 Value : Object representing first line
 * 			Key: 02 Value: Object representing second line

 */

public class Employee {

	private String EmployeeID, FirstName, LastName, Role;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeID, String firstName, String lastName, String role) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		Role = role;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Role="
				+ Role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EmployeeID == null) ? 0 : EmployeeID.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((Role == null) ? 0 : Role.hashCode());
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
		if (EmployeeID == null) {
			if (other.EmployeeID != null)
				return false;
		} else if (!EmployeeID.equals(other.EmployeeID))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (Role == null) {
			if (other.Role != null)
				return false;
		} else if (!Role.equals(other.Role))
			return false;
		return true;
	}
	
	
}

package question24_25_26_27_28;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String role;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		String temp = "";
		temp += employeeID + ", ";
		temp += firstName + ", ";
		temp += lastName + ", ";
		temp += role;
		return temp;
		//return new String(employeeID + ", " firstName + ", " lastName + ", " role);
	}
}

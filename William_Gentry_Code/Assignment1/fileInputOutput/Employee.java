package fileInputOutput;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String role;
	
	public Employee(int id, String first, String last, String role) {
		this.employeeId = id;
		this.firstName = first;
		this.lastName = last;
		this.role = role;
	}
	
	public int getEmployeeId() {return this.employeeId;}
	public String getFirstName() {return this.firstName; }
	public String getLastName() {return this.lastName;}
	public String getRole() {return this.role;}
	
	public String toString() {
		return String.format("Employee ID: %d Name: %s %s Role: %s", this.getEmployeeId(), this.getFirstName(), this.getLastName(), this.getRole());
	}
}

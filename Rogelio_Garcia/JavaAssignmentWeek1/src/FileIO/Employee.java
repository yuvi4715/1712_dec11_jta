package FileIO;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String role;
	
	public Employee(int id, String firstName, String lastName, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	};
	public String toString() {
		return "id: " + id + " first name: " + firstName + " last name: " + lastName + " role: " + role;
	}
}

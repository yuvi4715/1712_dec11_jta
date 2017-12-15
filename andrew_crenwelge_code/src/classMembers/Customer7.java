package classMembers;

public class Customer7 {
	/*
	 *  Create a Customer class with:
	 *	At least 2 constructors
	 *	At least 2 overloaded methods
	 *	At least 1 static variable
	 *	At least 2 static methods
	 *	At least 1 final variable
	 */
	
	public static int numCust; // static variable
	public String name;
	public int numItems;
	private String firstName;
	private String lastName;
	public static final int maxItems = 100; // static & final variable
	
	// first constructor
	public Customer7() {
		System.out.println("New customer added");
		numCust++;
	}
	// second constructor
	public Customer7(String firstName, String lastName) {
		super();
		System.out.println("New customer added");
		this.setCustName(firstName, lastName);
		this.name = firstName + " " + lastName;
		numCust++;
	}
	
	// static method
	public static int getNumCustomers() {
		return numCust;
	}
	// static method
	public static void sayGreeting() {
		System.out.println("Hello!");
	}
	
	public String getCustName() {
		return this.name;
	}
	
	// overloaded method
	public void setCustName(String name) {
		this.name = name;
	}
	// overloaded method
	public void setCustName(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	// overloaded method
	public void addItem() {
		this.numItems++;
	}
	// overloaded method
	public void addItem(int numOfItems) {
		this.numItems+=numOfItems;
	}
	public void changeName() {
		setFirstName("Bob");
		setLastName("Smith");
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
	
}

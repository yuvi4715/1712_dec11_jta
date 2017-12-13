package sample;

public class Customer7 {
	public static int numCust;
	public String name;
	public int numItems;
	private String firstName;
	private String lastName;
	public static final int maxItems = 100;
	
	public static int getNumCustomers() {
		return numCust;
	}
	public static void sayGreeting() {
		System.out.println("Hello!");
	}
	public String getCustName() {
		return this.name;
	}
	public void setCustName(String name) {
		this.name = name;
	}
	public void setCustName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void addItem() {
		this.numItems++;
	}
	public void addItem(int numOfItems) {
		this.numItems+=numOfItems;
	}
	
	public Customer7() {
		System.out.println("New customer added");
		numCust++;
	}

	public Customer7(String firstName, String lastName) {
		super();
		System.out.println("New customer added");
		this.setCustName(firstName, lastName);
		this.name = firstName + " " + lastName;
		numCust++;
	}
	
}

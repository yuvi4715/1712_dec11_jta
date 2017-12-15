package ClassMembers;

// 8
public class Customer {
	public final static double rate = .02;
	private final int id;
	private String name;
	private int age;
	
	public Customer(String name) {
		id = 0;
		this.name = name;
		this.age = 0;
	}
	public Customer(String name, int age) {
		id = 0;
		this.name = name;
		this.age = age;
	}
	public void talk() {
		System.out.println("Customer speaks");
	}
	public void talk(String message) {
		System.out.println("Customer says: " + message);
	}
	public void pay() {
		System.out.println("Customer pays");
	}
	public void pay(String payment) {
		System.out.println("Customer pays with: " + payment);
	}
	public static void makeSugestion() {
		System.out.println("Make suggestion");
	}
	public static void makeRequest() {
		System.out.println("make request");
	}
	
	
	
}

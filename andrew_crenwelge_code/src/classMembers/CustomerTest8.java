package classMembers;

public class CustomerTest8 {
	/*
	 * Create a main method in a new class that:
	 * 		-Creates 2 customers
	 * 		-Uses each of the Customer class members
	 */
	

	public static void main(String[] args) {
		// use both constructors
		Customer7 Bob = new Customer7();
		Customer7 Steve = new Customer7("Steve", "Smith");
		
		// call static customer methods
		Customer7.sayGreeting();
		System.out.println(Customer7.getNumCustomers());
		
		// call bob's methods
		Bob.changeName();
		System.out.println(Bob.getFirstName());
		System.out.println(Bob.getLastName());
		System.out.println(Bob.getCustName());
		
		// call set methods on steve
		Steve.setCustName("AGreatCustomer");
		Steve.setCustName("Charlie", "Chaplin");
		
		// both customers add a single item
		Bob.addItem();
		Steve.addItem();
		
		// Bob adds 4 more items polymorphically
		Bob.addItem(4);
		
		// get the constant maxItems
		System.out.println(Customer7.maxItems);
	}
}

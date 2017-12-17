package assign_1;           //This class is for number 7


public class Customer {
	
	String fName; // create a String variable fName without initializing it
	String lName;
	static int id; // create a static int variable id
	final String customerOf = "Best Buy"; // create a final String variable with the store name
	
	
	Customer() { // empty constructor
	}
	
	Customer(String fName, String lName, int id) { // overloaded constructor 
		this.fName = fName;
		this.lName = lName;
		Customer.id = id;
		
	}
	
	public static void name(String fName) { // class called name which prints the customers first name
		System.out.println("This customers first name is: " + fName);
	}
	
	public static void name(String fName, String lName) { // class called name which prints the customers first and last names
		System.out.println("This customers first and last name is: " + fName + " " + lName);
	}
	
	public static void nameAndId(String fName, String lName, int id) { // class called name which prints the customers first name, last name, and id number
		System.out.println("This customers first name, last name, and id is: " + fName + " " + lName + " " + id);
	}
}

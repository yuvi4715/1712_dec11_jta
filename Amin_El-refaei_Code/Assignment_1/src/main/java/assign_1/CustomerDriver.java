package assign_1;			//this is the driver class for number 8 of assignment 1

public class CustomerDriver {

	public static void main(String[] args) {
		Customer c1 = new Customer(); // customer c1 created with empty constructor
		Customer c2 = new Customer("Aisha", "Ashraf", 5151994); // customer c2 created with overloaded constructor
		Customer.name(c2.fName); // calls name method to return customers first name
		Customer.name(c2.fName, c2.lName); // calls overloaded name method to return customers first name and last name
		Customer.nameAndId(c2.fName, c2.lName, Customer.id); // calls nameAndId method to return customers first name, last name, and id

	}

}

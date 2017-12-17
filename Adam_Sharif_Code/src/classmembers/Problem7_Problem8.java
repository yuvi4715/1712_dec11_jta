package classmembers;
class Customer {
	public int id;
	public String name;
	static int count = 0;
	final String customerinfo = "Customer has been created";

	Customer(int id) {
		this.id = id;
		count++;
	}

	Customer(int id, String name) {
		this.id = id;
		this.name = name;
		count++;
	}
}

public class Problem7_Problem8 {

	public static void main(String[] args) {
		Customer person1 = new Customer(55403);
		System.out.println(person1.customerinfo);
		System.out.println("Customer ID is: " + person1.id);

		Customer person2 = new Customer(44324, "Wendy");
		System.out.println(person2.customerinfo);
		System.out.println("Customer ID is: " + person2.id + " and Customer name is: " + person2.name);

		System.out.println("The number of objects created: " + Customer.count);
	}

}

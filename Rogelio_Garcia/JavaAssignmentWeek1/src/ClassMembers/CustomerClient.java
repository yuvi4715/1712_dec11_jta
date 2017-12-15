package ClassMembers;

// 9
public class CustomerClient {
	public static void main(String[] args) {
		Customer john = new Customer("john");
		Customer jane = new Customer("jane", 20);
		john.talk();
		jane.talk("Hello");
		john.pay();
		jane.pay("debit");
		Customer.makeRequest();
		Customer.makeSugestion();
		System.out.println(Customer.rate);
	}
}

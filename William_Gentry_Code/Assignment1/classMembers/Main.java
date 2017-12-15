package classMembers;

public class Main {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		
		Customer enrolledCustomer = Customer.enrollCustomer(c2, "William", "test@email.com");
		
		c1.addItemToCart();
		c1.addItemToCart();
		c1.addItemToCart();
		
		enrolledCustomer.addItemToCart(15);
		
		Customer.checkoutSummary(c1);
		System.out.println("\n");
		Customer.checkoutSummary(enrolledCustomer);
	}
}

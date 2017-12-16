package getasew.assignment1.classmembers;
/*
 *8.Create a main method in a new class that:
Creates 2 customers
Uses each of the Customer class members

 */
public class CustomerMain {
	public static void main(String[] str) {
		Customer one = new Customer("Joseph","Perry","651-429-2186",45);
		Customer two = new Customer("Taylor","George","757-890-4756",28);
		
		System.out.printf("customer one name is: %s%n",one.getCustomerName());
		System.out.printf("customer one phone nubmer is: %s%n",one.getCustomerPhoneNumber());
		System.out.printf("customer one age is: %d%n",one.getCustomerAge());
		
		System.out.printf("customer two name is: %s%n", two.getCustomerName());
		System.out.printf("customer two phone number is: %s%n", two.getCustomerPhoneNumber());
		System.out.printf("customer two age is: %d%n",two.getCustomerAge());
		
		System.out.printf("number of customer is: %d%n", Customer.getNumberOfCustomer());
		System.out.printf("Name of business is: %s%n", Customer.getTheBusineesName());
		
		one.updateCustomerInfo("540-765-9810");
		one.updateCustomerInfo("Kennedy","Jordan","540-785-4810",56);
		two.updateCustomerInfo("804-219-8960");
		two.updateCustomerInfo("Ryan","Barton","757-897-1254",32);
		
		System.out.printf("customer one name is: %s%n",one.getCustomerName());
		System.out.printf("customer one phone nubmer is: %s%n",one.getCustomerPhoneNumber());
		System.out.printf("customer one age is: %d%n",one.getCustomerAge());
		
		System.out.printf("customer two name is: %s%n", two.getCustomerName());
		System.out.printf("customer two phone number is: %s%n", two.getCustomerPhoneNumber());
		System.out.printf("customer two age is: %d%n",two.getCustomerAge());
		
		System.out.printf("number of customer is: %d%n", Customer.getNumberOfCustomer());
		System.out.printf("Name of business is: %s%n", Customer.getTheBusineesName());
		
		
		
		
	}

}

package sample;

public class CustomerTest8 {

	public static void main(String[] args) {
		Customer7 Bob = new Customer7();
		Customer7 Steve = new Customer7("Steve", "Smith");
		Bob.sayGreeting();
		Steve.addItem();
		System.out.println(Customer7.getNumCustomers());
	}
}

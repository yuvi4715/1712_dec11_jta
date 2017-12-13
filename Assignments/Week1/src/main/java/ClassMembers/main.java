package ClassMembers;

public class main {
	
	public static void main(String[] args) {
		Customer cust1 = new Customer('m', 100);

		
		System.out.println("\nRunning Customer One");
		cust1.name("Jose", "Perez");
		
		
		String[] cust1items = {"shampoo", "bread", "milk", "eggs"};
		
		//these parameters are optional
		cust1.displaygender();
		cust1.displaymoney();
		
		cust1.cart(cust1items);

		System.out.println("\nRunning Customer Two");
		Customer cust2 = new Customer('f', 300);

		cust2.name("Matilda", "Jenkins");
		
		String[] cust2items = {"blinds", "lamp", "chairs", "stove"};
		
		//these parameters are optional
		cust2.displaygender();
		cust2.displaymoney();
		
		cust2.cart(cust2items);
		
	}
}

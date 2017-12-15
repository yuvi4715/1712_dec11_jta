package classMembers;

public class Customer {
	
	private String name;
	private String email;
	private static double memberDiscount = 0.25;
	private int numItemsInCart;
	private boolean isMember;
	private static final int pricePerItem = 3;
	
	
	public Customer() { 							//non-member constructor
		this.numItemsInCart = 0;
		this.isMember = false;
	}
	
	public Customer(String name, String email) {	//member constructor
		this.numItemsInCart = 0;
		this.name = name;
		this.email = email;
		this.isMember = true;
	}
	
	
	public double checkout() {
		if (this.isMember()) {
			return (this.numItemsInCart * Customer.pricePerItem * Customer.memberDiscount);  
		} else {
			return (this.numItemsInCart * Customer.pricePerItem);
		}
	}
	
	public void addItemToCart() {
		this.numItemsInCart++;
	}
	
	public void addItemToCart(int items) {
		this.numItemsInCart += items;
	}
	
	public static void checkoutSummary(Customer c) {
		if (c.getName() != null && c.getEmail() != null) {
			System.out.println("Name: " + c.getName());
			System.out.println("Email: " + c.getEmail());
		}
		System.out.println("Total Items: " + c.getNumItemsInCart());
		System.out.println("Member Price: " + c.isMember());
		System.out.println("Total: " + c.checkout());
		System.out.println("Thank you for shopping with us!");
	}
	
	public static Customer enrollCustomer(Customer c, String name, String email) {
		return c = new Customer(name, email);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumItemsInCart() {
		return numItemsInCart;
	}

	public void setNumItemsInCart(int numItemsInCart) {
		this.numItemsInCart = numItemsInCart;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	
	
	

}

package com.revature.as1.classmembers;

public class Customer {

	private final int CHARGE_MIN = 5;
	
	private static int numCustomers = 0;
	
	private int customerID;
	
	private int cashOnHand;
	
	private int cashOnCard;
	

	
	public Customer() {
		numCustomers++;
		customerID = numCustomers;
		this.cashOnHand = 0;
	}
	
	
	
	public Customer(int cashOnHand, int cashOnCard) {
		super();
		numCustomers++;
		customerID = numCustomers;
		this.cashOnHand = cashOnHand;
		this.cashOnCard = cashOnCard;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CHARGE_MIN;
		result = prime * result + cashOnCard;
		result = prime * result + cashOnHand;
		return result;
	}

	

	public int getCashOnHand() {
		return cashOnHand;
	}



	public void setCashOnHand(int cashOnHand) {
		this.cashOnHand = cashOnHand;
	}



	public int getCashOnCard() {
		return cashOnCard;
	}



	public void setCashOnCard(int cashOnCard) {
		this.cashOnCard = cashOnCard;
	}



	public int getCustomerID() {
		return customerID;
	}

	public void checkout(int total) {
		//No cardtype == cash transaction
		if(total <= cashOnHand) {
			cashOnHand -= total;
			System.out.println("Enjoy your $" + total + " purchase Customer " + customerID );
		}else {
			System.out.println("You don't have enough cash " + customerID);
		}
	}
	
	public void checkout(int total, String cardType) {
		//We don't actually care what the cardType is, but it signifies to us we're making a credit transaction
		if(total <= cashOnCard) {
			cashOnCard -= total;
			System.out.println("Enjoy your $" + total + " purchase Customer " + customerID );
		}else {
			System.out.println("You don't have enough on your card " + customerID);
		}
	}
	
	public static int getNumCustomers() {
		return numCustomers;
	}
	
	public static void addCustomer() {
		//Why do we have untracked customers? Project requirements, mostly.
		numCustomers++;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (CHARGE_MIN != other.CHARGE_MIN)
			return false;
		if (cashOnCard != other.cashOnCard)
			return false;
		if (cashOnHand != other.cashOnHand)
			return false;
		return true;
	}

}

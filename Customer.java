package com.revature.day1;

public class Customer {

	static int Anger_level;
	//final int exit_door;
	
	public Customer()
	{
		
	}
	
	public Customer(boolean hasanattitude)
	{
		
	}
	
	// 2 overloaded methods
	public void treat_customer(boolean attitude)
	{
		System.out.println("tell the customer to -kindly submit complaint to the manger");
	}
	
	public void treat_customer()
	{
		System.out.println("reset customer's password");
	}
	
	// 2 static methods
	
	static void complain()
	{
		System.out.println("customer proclaims that you should unlock her despite not having verification");
	}
	
	static void request_unlock()
	{
		System.out.println("customer requests a laptop upgrade");
	}
}

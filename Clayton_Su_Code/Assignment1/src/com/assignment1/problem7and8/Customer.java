package com.assignment1.problem7and8;

public class Customer {
	final int id;
	static double totalConsumption;
	static int numCustomers;
	double moneySpent = 0;
	int pointsEarned = 0;
	int authorizedID;
	String name;
	
	Customer()
	{
		this.id = 0;
		this.name = "";
		Customer.setNumCustomers(numCustomers++);
	}
	
	Customer(int id, String name)
	{
		 this.id = id;
		 this.name = name;
		 Customer.setNumCustomers(numCustomers++);
		 System.out.println(getNumCustomers());
		 System.out.println(getId());
	}
	
	public int getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public double getMoneySpent() {
		return moneySpent;
	}

	public void setMoneySpent(double moneySpent) {
		this.moneySpent = moneySpent;
	}

	public static int getNumCustomers() {
		return numCustomers;
	}

	public static void setNumCustomers(int numCustomers) {
		Customer.numCustomers = numCustomers;
	}

	public double getTotalConsumption() {
		return totalConsumption;
	}

	public static void setTotalConsumption(double totalConsumption) {
		Customer.totalConsumption = totalConsumption;
	}
	
	public int getId() {
		return id;
	}
	
	public void spend(double money)
	{
		this.setMoneySpent(moneySpent+money);
		Customer.setTotalConsumption(totalConsumption + money);
		System.out.println(getMoneySpent());
		System.out.println(getPointsEarned());
		System.out.println(getTotalConsumption());
	}
	
	public void spend(double money, int points)
	{
		this.moneySpent = this.moneySpent + money;
		this.setPointsEarned(pointsEarned + points);
		Customer.setTotalConsumption(totalConsumption + money);
		System.out.println(getMoneySpent());
		System.out.println(getPointsEarned());
		System.out.println(getTotalConsumption());
		
	}
	
	public void addAuthorizedUser(int id)
	{
		this.authorizedID = id;
	}
	
	public void addAuthorizedUser()
	{
		this.authorizedID = 1111;
		//temp guest id
	}
	
	
	
	
}
package com.assignment1.problem7and8;

public class Main {
	public static void main(String[] args) {
		Customer a = new Customer();
		Customer b = new Customer(5,"John");
		
		
		a.spend(20.17);
		b.spend(17.18, 5);
		
		b.addAuthorizedUser(a.getId());
		a.addAuthorizedUser();
	}
}

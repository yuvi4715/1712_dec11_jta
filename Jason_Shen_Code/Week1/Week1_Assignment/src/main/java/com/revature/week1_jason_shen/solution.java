package com.revature.week1_jason_shen;

public class solution {
	public static void main(String args[]) {
		
		// Core Java: Questions 1-3
		System.out.println("Question 1: \n-----");
		core.basicOps();
		
		System.out.println("Question 2: \n-----");
		core.findGreatest(4,5,6);
		
		System.out.println("Question 3: \n-----");
		core.checkBools();
		
		
		// Syntax: Questions 4-6
		System.out.println("Questions 4 and 5: \n-----");
		syntax.basicOps_2.add(1,2);
		syntax.basicOps_2.subtract(6, 3);
		syntax.basicOps_2.multiply(5, 10);
		syntax.basicOps_2.divide(24, 3);
		System.out.println();
		
		System.out.println("Question 6: \n-----");
		syntax.controls(100, 3);
		System.out.println();
		
		// Class Members: Questions 7-8
		System.out.println("Question 7 and 8: \n-----");
		customer Jason = new customer(22, "Revature");
		customer Yuvi = new customer();
		
		System.out.println("Jason's info: ");
		Jason.getAge();
		Jason.setAge(30);
		Jason.getAge();
		Jason.getShares();
		Jason.getCompany();
		Jason.buyShares();
		Jason.getShares();
		System.out.println();
		
		System.out.println("Yuvi's info: ");
		Yuvi.getAge();
		Yuvi.setAge(50);
		Yuvi.getAge();
		Yuvi.getShares();
		Yuvi.getCompany();
		Yuvi.buyShares(50);
		Yuvi.getShares();
		System.out.println();
		
		System.out.println("Static customer information: ");
		customer.getBank();
		customer.setBank("TD");
		customer.getBank();
		customer.getTotalFunds();
	}
	
}

package com.revature.week1_jason_shen;

import com.revature.week1_jason_shen.Oop.Human;
import com.revature.week1_jason_shen.Oop.Mammal;

public class Solution {
	public static void main(String args[]) throws Exception {
		
		// CORE JAVA -- QUESTIONS 1-3
		System.out.println("Question 1: \n-----");
		Core.basicOps();
		
		System.out.println("Question 2: \n-----");
		Core.findGreatest(4,5,6);
		
		System.out.println("Question 3: \n-----");
		Core.checkBools();
		
		
		// SYNTAX -- QUESTIONS 4-6
		System.out.println("Questions 4 and 5: \n-----");
		Syntax.basicOps_2.add(1,2);
		Syntax.basicOps_2.subtract(6, 3);
		Syntax.basicOps_2.multiply(5, 10);
		Syntax.basicOps_2.divide(24, 3);
		System.out.println();
		
		System.out.println("Question 6: \n-----");
		Syntax.controls(100, 3);
		System.out.println();
		
		// CLASS MEMBERS -- QUESTIONS 7-8
		System.out.println("Question 7 and 8: \n-----");
		Customer Jason = new Customer(22, "Revature");
		Customer Yuvi = new Customer();
		
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
		Customer.getBank();
		Customer.setBank("TD");
		Customer.getBank();
		Customer.getTotalFunds();
		System.out.println();
		
		
		// OOP -- Question 9
		System.out.println("Question 9: \n-----");
		Animal one = new Oop.Human();
		Mammal two = new Oop.Human();
		Human three = new Oop.Human();
		
		System.out.println("Animal: " );
		one.eat("grass");
		one.move();
		System.out.println();
		
		System.out.println("Mammal: " );
		two.eat("meat");
		two.move();
		// Assignment asked for walk to be static method, so we have to call from Mammal
		Mammal.walk(5);
		System.out.println();
		
		System.out.println("Human: " );
		three.eat("grass");
		three.move();
		// Calling static method from class
		Human.walk(6);
		System.out.println();	
		
		// EXCEPTIONS -- Questions 10-15
		System.out.println("Question 10-15: \n-----");
		ThrowsMyCustomException test_my_exception = new ThrowsMyCustomException();
		
		// Normal try catch
		test_my_exception.myTryCatch();

		// Uses duckMyException() throws and ducks an exception, so in order to not break our main() method
		// We need to use another try catch here. We could have also set our main to duck this exception.
		try {
			// This line ducks an exception
			test_my_exception.duckMyException();
		}
		catch (MyCustomException e) {
			System.out.println("Ducked!");
		}
		System.out.println();
		
		// ADVANCED CONCEPTS -- QUESTIONS 16-20
		System.out.println("Question 16: \n-----");
		AdvancedConcepts.stringBuilding();
		System.out.println();
		
		System.out.println("Question 17: \n-----");		
		AdvancedConcepts.tokens();
		System.out.println();
		
		System.out.println("Question 18 and 19: \n-----");		
		AdvancedConcepts.addStrings("15", "30");
		System.out.println();
		
		System.out.println("Question 20: \n-----");		
		AdvancedConcepts.myRuntime();
		System.out.println();
		
		// COLLECTIONS -- QUESTIONS 21-23
		
		System.out.println("Question 21-23: \n-----");
		MyCollections.myArrayList();
		System.out.println();
		MyCollections.myLinkedList();
		System.out.println();
		MyCollections.myHashMap();
		System.out.println();
		MyCollections.myTreeSet();		
		System.out.println();
		MyCollections.myHashSet();	
		System.out.println();
		
		// FILE I/O -- QUESTIONS 24-28
		System.out.println("Question 24-28: \n-----");
		FileIO.parseFile("fileio.txt");
		System.out.println();
		
		// MULTITHREADING -- QUESTIONS 29-31
		System.out.println("Question 29-31: \n-----");
		Thread t1_async = new Thread(new Multithreading("Thread 1"));
		Thread t2_async = new Thread(new Multithreading("Thread 2"));
		Thread t3_async = new Thread(new Multithreading("Thread 3"));
		t1_async.start();
		t2_async.start();
		t3_async.start();
		
		t1_async.join();
		t2_async.join();
		t3_async.join();
		
		System.out.println("All asynchronous threads done, starting synchronized threads.");
		Thread t1_sync = new Thread(new MultithreadingSynced("Thread 1 Synced"));
		Thread t2_sync = new Thread (new MultithreadingSynced("Thread 2 Synced"));
		Thread t3_sync = new Thread (new MultithreadingSynced("Thread 3 Synced"));
		t1_sync.start();
		t2_sync.start();
		t3_sync.start();

		t1_sync.join();
		t2_sync.join();
		t3_sync.join();
		// How do I wait for these threads to finish before starting main again???
		
		System.out.println("All threads complete, continuing main");
	}
	
}

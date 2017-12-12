package com.revature;

import java.util.ArrayList;

public class main {

	//this is the main class to display all the values!
	public static void main(String[] args) {
		// might add a menu so all of this is not running at once!
		
		//hard coded values first!
		Calculator cal = new Calculator();
		HardcodedCalculator hc = new HardcodedCalculator();
		ControlStatements cs = new ControlStatements();
		Collect collect = new Collect();
		System.out.println("Hardcoded Calculator Running!");
		hc.add();
		hc.divide();
		hc.substract();
		hc.multiply();
		
		System.out.println("\nRunning Calculator");
		
		cal.add(5, 2);
		cal.substract(5, 2);
		cal.multiply(5, 2);
		cal.divide(23, 9);
		
		System.out.println("\nRunning Control Statements");
		cs.controls();
		
		System.out.println("\nRunning Short Circuit Operators");
		ShortCircuit sc = new ShortCircuit();
		sc.message();
				
		System.out.println("\nRunning Customer One");
		Customer cust1 = new Customer('m', 10);
		cust1.name("Jose", "Perez");
		
		
		String[] cust1items = {"shampoo", "bread", "milk", "eggs"};
		
		//these parameters are optional
		cust1.displaygender();
		cust1.displaymoney();
		
		cust1.cart(cust1items);

		System.out.println("\nRunning Customer Two");
		Customer cust2 = new Customer('f', 40);
		cust2.name("Matilda", "Jenkins");
		
		String[] cust2items = {"blinds", "lamp", "chairs", "stove"};
		
		//these parameters are optional
		cust2.displaygender();
		cust2.displaymoney();
		
		cust2.cart(cust2items);
		
		Animal aone = new Human();
		Mammal mone = new Human();
		Human hone = new Human();
		
		Animal atwo = new Mammal();
		Mammal mtwo = new Mammal();
		
		System.out.println("\nChecking Animal One");
		aone.eat();
		aone.move();
		System.out.println("\nChecking Animal Two");
		atwo.eat();
		atwo.move();
		System.out.println("\nChecking Mammal One");
		mone.eat();
		mone.move();
		mone.walk();
		System.out.println("\nChecking Mammal Two");
		mtwo.eat();
		mtwo.move();
		mtwo.walk();
		System.out.println("\nChecking Human One");
		hone.eat();
		hone.move();
		hone.walk();
		System.out.println("\nHuman Two will not run since Mammal does not extend Human!");
		
		/*
		 * 
		 * write the exception block here
		 * 
		 * 
		 * */
		
		System.out.println("\nManipulating Strings!");
		
		ManipulateStrings ms = new ManipulateStrings();
		
		char[] somechar = {'H','e','l','l','o'};
		String first = "10";
		String second = "20";
		
		ms.stringLenght("Hello My Name Is Jose Perez");
		ms.charToString(somechar);
		ms.letterCount("Oh Mcdonald had a farm");
		ms.reverseString("Welcome to Revature!");
		ms.parser("Hello:Captain:Pickles:How:Are:You:Today?", ":");
		ms.addStrings(first, second);
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Character> list3 = new ArrayList<Character>();
		list1.add("Hello");
		list1.add("World");
		list1.add("How");
		list1.add("Are");
		list1.add("You?");
		
		list2.add(1);
		list2.add(10);
		list2.add(35);
		list2.add(9);
		list2.add(7);
		
		list3.add('a');
		list3.add('c');
		list3.add('f');
		list3.add('b');
		list3.add('z');
		
		
		
		collect.arraylist(list1, list2, list3);
		
		
		
		

	}

}

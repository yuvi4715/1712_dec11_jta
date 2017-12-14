package com.revature.day2;

public class StaticExample {
	
	// 1 - Static variables
	// 2 - Static blocks
	// 3 - Non Static Variables
	// 4 - Non Static Block
	// 5 - Constructor
	
	//class members - variables, constructors, blocks, methods
	//scope - block, object, class, method
	static int staticVariable = 10;		//static variable
	int nonStaticVariable = 10;			//instance variable
	{
		System.out.println("BLOCK");
	}	
	
	static {
		System.out.println("Static Block");
	}
	
	public StaticExample() {
		System.out.println("Constructor");
	}
	
	//static belongs to class
	//static members can be accessed from static and non-static context
	//non-static members can not be accessed from static context
	
	public static void main(String[] args) {
		System.out.println("inside main method");
		staticVariable++;
		StaticExample s1 = new StaticExample();
		s1.nonStaticVariable++;
		//System.out.println("value of staticVariable: " + staticVariable);			//11
		//System.out.println("value of nonStaticVariable: " + s1.nonStaticVariable);	//11
		s1.myMethod2();
		//myMethod3();
	}
	
	public void myMethod1() {
		System.out.println("myMethod1");
		staticVariable++;
		nonStaticVariable++;
		//System.out.println("value of staticVariable: " + staticVariable);			//12 
		//System.out.println("value of nonStaticVariable: " + nonStaticVariable);		//11
		myMethod3();
	}
	
	public void myMethod2() {
		System.out.println("myMethod2");
		StaticExample s1 = new StaticExample();
		s1.myMethod1();
		int localVariable = 10;
		System.out.println(localVariable);			//10
	}

	public static void myMethod3() {
		System.out.println("myMethod3");
		staticVariable++;
		StaticExample s1 = new StaticExample();
		s1.nonStaticVariable++;
		//System.out.println("value of staticVariable: " + staticVariable);			//13
		//System.out.println("value of nonStaticVariable: " + s1.nonStaticVariable);	//11 	
	}
	

}

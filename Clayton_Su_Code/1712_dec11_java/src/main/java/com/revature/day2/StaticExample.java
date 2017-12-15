package com.revature.day2;

public class StaticExample {

	
	
	static int staticVariable;
	int nonStaticVariable;
	
	//statis members can be accescced from static and non staitc context
	//non static members cannot be accessed from static context so create an instance
	public static void main(String[] args) {
		staticVariable = 10;
		StaticExample s1 = new StaticExample();
		s1.nonStaticVariable =15;
		s1.nonStaticVariable++;

		System.out.println("staticVar" + staticVariable);
		System.out.println("nonstaticVar" + s1.nonStaticVariable);
		s1.myMethod();
	}
	
	public void myMethod()
	{
		//staticVariable = 20;
		staticVariable++;
		nonStaticVariable++;
		
		System.out.println("staticVar" + staticVariable);
		System.out.println("nonstaticVar" + nonStaticVariable);
	}
	
	public void myMethod2()
	{
		StaticExample s1 = new StaticExample();
		s1.myMethod();
	}

}

package com.revature.as1;

public class Project3 implements TestableProject {

	private boolean a;
	private boolean b;
	
	public Project3() {
		a = true;
		b = false;
	}
	
	public void test() {
		System.out.println("!a returns: " + !a);
		System.out.println("a | b returns: " + (a|b));
		System.out.println("(!a & b) | (a & !b) returns: " + ((!a & b) | (a & !b)));
	}

	public void setup() {
		System.out.println("Project 3 requires no setup!");
	}

}

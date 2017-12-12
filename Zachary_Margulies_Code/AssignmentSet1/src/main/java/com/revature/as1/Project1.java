package com.revature.as1;

public class Project1 implements TestableProject {
	

	private final int A = 10;
	private final int B = 11;
	
	public void setup() {
		System.out.println("Project 1 requires no setup!");
	}
	
	public void test() {
		System.out.println("a + b: " + add());
		System.out.println("a - b: " + subtract());
		System.out.println("a * b: " + multiply());
		System.out.println("a/b: " + divide());
	}
	
	
	
	private int add() {
		return A+B;
	}
	
	private int subtract() {
		return A-B;
	}
	
	private int multiply() {
		return A*B;
	}
	
	private float divide() {
		try {
			return (float)A/B;
		}catch(Exception e) {
			System.out.println("You tried to divide by 0, didn't you.");
			return Float.NaN;
		}
	}
}
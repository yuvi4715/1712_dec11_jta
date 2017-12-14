package com.revature.as1;

public class Project2 implements TestableProject {

	private int a;
	private int b;
	private int c;

	public Project2() {
		a = 0;
		b = 0;
		c = 0;

	}

	public void setup() {
		KeyboardInputScanner in = new KeyboardInputScanner();
		int[] args = in.setIntArgs(3);

		setA(args[0]);
		setB(args[1]);
		setC(args[2]);

		in.close();
	}

	public void test() {
		System.out.println("The largest number is: " + compareInternals());
	}

	private int compareInternals() {
		if (a > b && a > c) {
			return a;
		} else if (b > c && b > a) {
			return b;
		} else {
			return c;
		}

	}

	private void setA(int newVal) {
		a = newVal;
	}

	private void setB(int newVal) {
		b = newVal;
	}

	private void setC(int newVal) {
		c = newVal;
	}
}

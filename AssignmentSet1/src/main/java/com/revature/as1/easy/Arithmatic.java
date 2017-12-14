package com.revature.as1.easy;

import com.revature.as1.KeyboardInputScanner;
import com.revature.as1.TestableProject;

public class Arithmatic implements TestableProject {

	public final String modes = "+, -, *, /";

	int mode;

	int[] args;

	public Arithmatic() {

	}
	
	public static void main(String[] args) {
		Arithmatic a = new Arithmatic();
		
		a.setup();
		
		a.test();
	}

	public void setup() {

		KeyboardInputScanner in = new KeyboardInputScanner();
		
		args = in.setIntArgs(2);

		mode = in.setMode(modes);

		

	}

	public void test() {
		// TODO Auto-generated method stub

		switch (mode) {
		case 0:
			System.out.println("A+B = " + add(args[0], args[1]));
			break;
		case 1:
			System.out.println("A-B = " + subtract(args[0], args[1]));
			break;
		case 2:
			System.out.println("A*B = " + multiply(args[0], args[1]));
			break;
		case 3:
			System.out.println("A/B = " + divide(args[0], args[1]));
			break;
		default:
			System.out.println("Something went horribly wrong. How did you get here. Usual Suspect: New parameters added without updating the possibility list.");
		}

	}

	private int add(int A, int B) {
		return A + B;
	}

	private int subtract(int A, int B) {
		return A - B;
	}

	private int multiply(int A, int B) {
		return A * B;
	}

	private float divide(int A, int B) {
		try {
			if (B != 0) {
				return (float) A / B;
			} else {
				return Float.NaN;
			}
		} catch (Exception e) {
			System.out.println("You shouldn't be here. Stop breaking things.");
			return Float.NaN;
		}
	}

}

package com.revature.assignment1.easy_coding_exercises;

public class CheckPassFail {

	public static void main(String[] args) {

		int mark = 25;
		if (mark >= 50) {
			doesPass();
		} else {
			doesFail();
		}
	}
	
	private static void doesPass() {
		System.out.println("PASS");
	}
	
	private static void doesFail() {
		System.out.println("FAIL");
	}

}

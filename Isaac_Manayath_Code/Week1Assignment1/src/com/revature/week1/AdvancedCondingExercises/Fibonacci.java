package com.revature.week1.AdvancedCondingExercises;

public class Fibonacci {

	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			count++;
			System.out.println(fibonacci(i) + " " + count);
		}
	}

	//printing out the 100 numbers of fibonacci may be impossible on 
	public static long fibonacci(long number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
	

package com.revature.as1.adv;

public class Fibonacci {
	
	public static void fibIterative() {
		double cur = 1, last = 1, twoLast = 0;
		System.out.println("First Fibonacci number is: " + cur);
		
		for(int i = 1; i < 100; i++) {
			
			cur = last + twoLast;
			twoLast = last;
			last = cur;
			System.out.println("Fibonacci number " + (i+1) + " is: " + cur);
		}
	}
	
	public static double fibRecursive(int fib) {
		if(fib == 0) {
			//System.out.println("Base");
			return 0;
		}else if(fib == 1) {
			//System.out.println("Base 1");
			return 1;
		}else {
			return fibRecursive(fib-1) + fibRecursive(fib-2);
		}
	}

}

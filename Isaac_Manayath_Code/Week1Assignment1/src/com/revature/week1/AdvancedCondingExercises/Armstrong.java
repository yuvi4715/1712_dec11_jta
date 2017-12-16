package com.revature.week1.AdvancedCondingExercises;

public class Armstrong {
	public static void main(String[] args) {
		int n = 153;
		int temp = n;
		int digits = 0;
		int sum = 0;
		int remainder;
		
		//count number of digits
		
		while(temp != 0) {
			digits++;
			temp = temp/10;
		}
		
		temp = n;
		
		while(temp != 0) {
			remainder = temp % 10;
			sum = (int) (sum + Math.pow(remainder, digits));
			temp = temp/10;
		}
		
		if (n==sum) {
			System.out.println("The number " + n + " is an Armstrong number");
		}else {
			System.out.println("The number " + n + " is not an armstrong number");
		}
	}
}
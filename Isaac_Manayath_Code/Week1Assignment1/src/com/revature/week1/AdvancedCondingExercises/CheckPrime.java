package com.revature.week1.AdvancedCondingExercises;

public class CheckPrime {
	public static void main(String args[]) {
		int num = 47;
		int a = 2;

		//Checking if 47 was prime
		if (num == 2) {
			System.out.println("It is a prime number");
		} else {
			while (num % a != 0 && num - 1 > a) {
				a++;
			}
			if (num == 1) {
				System.out.println("Not a prime number");
			} else if (num % a == 0) {
				System.out.println("It is not a prime number");
			}else {
				System.out.println("It is a prime number!");
			}
		}
	}
}

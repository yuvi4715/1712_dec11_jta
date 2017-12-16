package com.revature.week1.CoreJava;

public class GreatestOfThree {
	
	public static void main(String args[]) {
		System.out.println("The greatest of these three numbers is " + max(7,5,3));
		System.out.println("The greatest of these three numbers is " + max(3,7,5));
		System.out.println("The greatest of these three numbers is " + max(3,5,7));
	}
	
	//Finding the max of these numbers
	public static int max(int one, int two, int three) {
		int max = 0;
		
		if (one > two && one > three){
			max = one;
			return max;
		}else if (two > one && two > three){
			max = two;
			return max;
		}else {
			max = three;
			return max;
		}
	}
}

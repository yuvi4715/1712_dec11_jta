package com.revature.day1;

public class Assignment1_2 {
	
	public static void main(String[] args) {
		int x = 1010;
		int y = 500;
		int z = 10000;
		
		if(x > y && x > z)
			System.out.println(x);
		else if(y > x && y > z)
			System.out.println(y);
		else if(z > x && z > y)
			System.out.println(z);
		else
			System.out.println("all numbers are the same");


	}

}

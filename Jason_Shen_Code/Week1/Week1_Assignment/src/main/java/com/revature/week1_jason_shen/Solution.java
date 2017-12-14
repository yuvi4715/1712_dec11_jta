package com.revature.week1_jason_shen;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Run all? (Y/N)");
		String y_n = scan.next();
		if (y_n.toLowerCase().equals("y")) {
			Helper.run();
		}
		else if (y_n.toLowerCase().equals("n") ) {
			System.out.println("Enter question number to run: ");
			int q = scan.nextInt();
			Helper.run(q);
		}
		else {
			System.out.println("Invalid input.");
		}
		
		scan.close();
		
		
	}
	
}

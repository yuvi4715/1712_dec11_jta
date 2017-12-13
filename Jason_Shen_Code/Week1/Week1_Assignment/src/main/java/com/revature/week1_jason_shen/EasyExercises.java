package com.revature.week1_jason_shen;

import java.util.Scanner;

public class EasyExercises {
	
	// 32. Write a program called CheckPassFail which prints "PASS" 
	//     if the int variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.
	static void CheckPassFail(int mark) {
		if (mark >= 50) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
	}
	
	// 33. Write a program called CheckOddEven which prints "Odd Number" if the int variable “number”
	//     is odd, or “Even Number” otherwise. Hint: you may use modulus operator.

	static void CheckOddEven (int number) {
		if (number % 2 == 0) {
			System.out.println("Even number");
		}
		else {
			System.out.println("Odd number");
		}
	}
	
	// 34. Write a program called PrintNumberInWord which prints 
	//     "ONE", "TWO",... , "NINE", "OTHER" if the int variable "number"  
	//     is 1, 2,... , 9, or other, respectively. Use (a) a "nested-if" 
	//     statement; (b) a "switch-case" statement.
	static void PrintNumberInWord(int number) {
		if (number == 1)
			System.out.println("ONE");
		else if (number == 2)
			System.out.println("TWO");
		else if (number == 3)
			System.out.println("THREE");
		else if (number == 4)
			System.out.println("FOUR");
		else if (number == 5)
			System.out.println("FIVE");
		else if (number == 6)
			System.out.println("SIX");
		else if (number == 7)
			System.out.println("SEVEN");
		else if (number == 8)
			System.out.println("EIGHT");
		else if (number == 9)
			System.out.println("NINE");
		else
			System.out.println("OTHER");
		
//		Using switch cases:
//		switch(number) {
//			case 1:
//				System.out.println("ONE");
//				break;
//			case 2:
//				System.out.println("TWO");
//				break;
//			case 3:
//				System.out.println("THREE");
//				break;
//			case 4:
//				System.out.println("FOUR");
//				break;
//			case 5:
//				System.out.println("FIVE");
//				break;
//			case 6:
//				System.out.println("SIX");
//				break;
//			case 7:
//				System.out.println("SEVEN");
//				break;
//			case 8:
//				System.out.println("EIGHT");
//				break;				
//			case 9:
//				System.out.println("NINE");
//				break;
//			default:
//				System.out.println("OTHER");
//		}
			
	}
	
	// 35. Write a program called KeyboardScanner to prompt user for an int, 
	//     a double, and a String. Print the input onto the console.
	static void KeyboardScanner( ) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an int: ");
		int i = scan.nextInt();
		System.out.println("Enter a double: ");
		double d = scan.nextDouble();
		System.out.println("Enter a string: ");
		String s = scan.next();
		System.out.println(i + d + s);
		scan.close();
	}
	
	// 36. 
}

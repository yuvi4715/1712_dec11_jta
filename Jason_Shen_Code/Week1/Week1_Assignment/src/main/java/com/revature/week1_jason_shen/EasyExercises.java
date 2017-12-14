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
		System.out.println("Please enter an int: ");
		int i = scan.nextInt();
		System.out.println("Please enter a double: ");
		double d = scan.nextDouble();
		System.out.println("Please enter a string: ");
		String s = scan.next();
		System.out.printf("%d %.2f %s \n", i ,d , s);
		scan.close();
	}
	
	// 36. Write a program called Arithmetic that takes three command-line arguments: 
	//     two integers followed by an arithmetic operator (+, -, * or /). The program shall 
	//     perform the corresponding operation on the two integers and print the result.
	
	
	// For this I just had the method take in parameters, but if I really wanted it to take command line 
	// args, I know that I would have to pass in args from main(String[] args).
	// Additionally there is and has been a long known bug regarding the usage of * as an argument.
	// Normally * is already being treated as a wildcard if used as an argument, but in eclipse specifically 
	// there seems to be no way to get around this. In the terminal, using \* instead of just * will allow you to 
	// use the asterisk literal, but in the eclipse ide, it doesn't behave this way.
	
	// See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=212264
	// https://stackoverflow.com/questions/3861086/how-to-avoid-glob-expansion-when-running-java-app-in-eclipse
	
	// From the command line it would look like:
	// javac Arithmetic 
	// java Arithmetic <x> <y> <operator>
	// 
	static void Arithmetic(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		String op = args[2];
		if (op.equals("+")) 
			System.out.println(x+y);
		else if (op.equals("-"))
			System.out.println(x-y);
		else if (op.equals("*"))
			System.out.println(x*y);
		else if (op.equals("/"))
			System.out.println(x/y);
		else
			System.out.println("Error: Check args");
	}
	
	// 37. Write a program called GradesStatistics, which reads in n grades (of int between 0 and 100, inclusive)
	//     and displays the average, minimum, maximum, and standard deviation. Your program shall check for valid 
	//     input. You should keep the grades in an int[] and use a method for each of the computations.
	
	
	// When it says "use a method", is it asking us to implement each method, or just use a library method??
	public static class GradesStatistics {
		static void grade(int[] grades) {
			// Check if input is valid
			for (int grade : grades) {
				if (grade < 0 || grade > 100) {
					System.out.println("Invalid input: Make sure all grades are between 0 and 100.");
					return;
				}
			}
			System.out.println("Average: " + average(grades));
			System.out.println("Minimum: " + minimum(grades));
			System.out.println("Maximum: " + maximum(grades));
			System.out.println("Standard Deviation " + std_dev(grades));
		}
		
		private static float average(int[] numbers) {
			float running_sum = 0;
			for (int number : numbers) {
				running_sum += number;
			}
			return running_sum / numbers.length;
		}
		
		private static int minimum(int[] numbers) {
			int curr_min = Integer.MAX_VALUE;
			for (int number : numbers) {
				if (number == 0) {
					return 0;
				}
				else if (number < curr_min) {
					curr_min = number;
				}
			}
			return curr_min;
		}
		
		private static int maximum(int[] numbers) {
			int curr_max = Integer.MIN_VALUE;
			for (int number : numbers) {
				if (number == 100) {
					return 100;
				}
				else if (number > curr_max) {
					curr_max = number;
				}
			}
			return curr_max;
		}		
		
		private static double std_dev(int[] numbers) {
			// Calculate sum of squared differences
			double sum_square_diff = 0;
			double average = EasyExercises.GradesStatistics.average(numbers);
			
			for (int number : numbers) {
				sum_square_diff += ((number - average)*(number - average));
			}
			double variance = sum_square_diff / numbers.length;
			double stddev = Math.sqrt(variance);
			return stddev;
		}
		
	}
}

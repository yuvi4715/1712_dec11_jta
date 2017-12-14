package com.revature.week1_jason_shen;

import java.util.Calendar;
import java.util.Comparator;

public class AdvancedExercises {

	// Cache to be used for question 40 - Recursive fibonacci with memoization
	public static long[] fibonacci_cache = new long[500];
	
	// 38. Write a method to replace a given character in a String with another character.
	// All instances?? First instance?? Specific instance??
	
	// This implementation is for all instances of a given char
	static void replaceCharInString(String s, char to_be_replaced, char replaced_by) {
		StringBuffer new_string = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == to_be_replaced) {
				new_string.append(replaced_by);
			}
			else {
				new_string.append(s.charAt(i));
			}
		}
		System.out.println("Original string: " + s);
		System.out.println("Character to be replaced: " + to_be_replaced);
		System.out.println("Character to be replaced by: " + replaced_by);
		System.out.println("New string: " + new_string);
	}
	
	// 39. Write a method that takes a date of birth via Calendar object and returns your age. If it is your 
	//     birthday, print the Happy Birthday song!
	static int happyBirthday(Calendar dob) {
		int age;
		Calendar today = Calendar.getInstance();
		int todays_month = today.get(Calendar.MONTH);
		int todays_day = today.get(Calendar.DAY_OF_MONTH);
		int dob_month = dob.get(Calendar.MONTH);
		int dob_day = dob.get(Calendar.DAY_OF_MONTH);
		
//		System.out.println(todays_month + " " + todays_day + " " + dob_month + " " + dob_day);
		
		// If todays month and day match dob's month and day, print happy birthday
		if (todays_month == dob_month && todays_day == dob_day) {
			System.out.println("Happy birthday to you!");
		}
		else {
			System.out.println("Hmm...not your birthday yet.");
		}
		
		// Subtract years to get age, except for if your birthday hasnt come yet for this year
		age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if ((todays_month < dob_month) || ((todays_month == dob_month) && (todays_day < dob_day))) {
			age -= 1;
		}
		System.out.println("Your age: " + age);
		return age;
	}
	
	// 40. Write a Java program to print the first 100 Fibonacci numbers using iteration. Rewrite using recursion.
	static void fibonacciIter(int n) {
		long fib1 = 0;
		long fib2 = 1;
		long curr_fib = fib1 + fib2;
		for (int i = 0; i < n-2; i++) {
			// New line every 10 numbers			
			if (i % 10 == 0) {
				System.out.println();
			}
			
			if (i == 0 || i == 1) {
				System.out.println(i);
			}
			else {
				System.out.println(curr_fib);
				fib1 = fib2;
				fib2 = curr_fib;
				curr_fib = fib1 + fib2;
			}
		}
	}
	
	// Fibonacci Recursive
	static long fibonacciRecur(int n) {
		if (n == 0) {			
			return n;
		}
		else if (n == 1) {
			return n;
		}
		else {
			long curr_fib = fibonacciRecur(n-1) + fibonacciRecur(n-2);
			return curr_fib;
		}
	}
	
	// Prints fibonacci recursive
	static void printFib(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(fibonacciRecur(i));
		}
		return;
	}
	
	// Fibonacci w/ Top-down Dynamic Programming
	static long fibonacciDP(int n) {
		if (n == 0) {
			return fibonacci_cache[n];
		}
		else if (n == 1) {
			if (fibonacci_cache[n] == 0) {
				fibonacci_cache[n] = 1;
			}
			return fibonacci_cache[n];
		}
		else if (fibonacci_cache[n] != 0) {
			return fibonacci_cache[n];  
		}
		else {
			fibonacci_cache[n] = fibonacciDP(n-1) + fibonacciDP(n-2);
			return fibonacci_cache[n];
		}
		
	}
	static void printFibDP(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(fibonacciDP(i));
		}
		return;
	}
	
	// 41. Write a Java program that prints the numbers from 1 to 50. But for multiples of three print "Fizz" 
	//     instead of the number and for the multiples of five print "Buzz". For numbers which are multiples of 
	//     both three and five print "FizzBuzz"
	
	static void fizzBuzz(int n) {
		for (int i = 1; i < n; i++) {
			if (i % 15 == 0 ) {
				System.out.println(i + " FizzBuzz");
			}
			else if (i % 5 == 0) {
				System.out.println(i + " Buzz");
			}
			else if (i % 3 == 0) {
				System.out.println(i + " Fizz");
			}	
		}
		
	}
	
	// 42. Write Comparators to compare two employees based on their name, department, and age.

	public static class Employee implements Comparable<Employee> {
		String name;
		String department;
		int age;
		
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int compareTo(Employee e) {
			return getName().compareTo(e.getName());
		}
		
	}
	public static class CompareEmployeeByName implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {	
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	public static class CompareEmployeeByDepartment implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {	
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
		
	}
	public static class CompareEmployeeByAge implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {	
			if (o1.getAge() < o2.getAge())
				return -1;
			else if (o1.getAge() == o2.getAge())
				return 0;
			else 
				return 1;			
		}
		
	}
	
	// 43. Write a Java program to check if a number is Armstrong or not.
	// An Armstrong number is a number that is equal to the sum of the cubes of its digits
	// Ex: 153 = 1^3 + 5^3 + 3^3
	//         = 1 + 125 + 27
	
	static void checkArmstrong(int to_check) {
		int curr = to_check;
		int sum_check = 0;
		while(curr > 0) {
			// 153 gives us the ones digit -> 3
			int curr_digit = curr % 10; 
			sum_check += (curr_digit * curr_digit * curr_digit);
			
			// Dividing by 10 gives us our next digit to check
			// 153 becomes 15, after which we would get 5 as our next digit on the next loop
			curr /= 10;
			
		}		
		if (sum_check == to_check) {
			System.out.println(to_check + " is Armstrong!");
		}
		else {
			System.out.println(to_check + " is not Armstrong.");
		}
	}
	// 44. Write a method to reverse a String without using API functions.
	// I'm gonna assume we can still use simple functions like length()...
	static String reverseString(String s) {
		StringBuffer new_string = new StringBuffer();
		for (int i = s.length()-1; i >= 0; i--) {
			new_string.append(s.charAt(i));
		}
		String string = new_string.toString();
		System.out.println("Original string: " + s);
		System.out.println("Reversed: " + string);
		return string;
	}	
	
	// 45. Write a method to determine if a number is prime.
	static boolean isPrime(int n) {
		if (n == 1 || n == 0) {
			System.out.println(n + " is not prime.");
			return false;
		}			
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println(n + " is not prime.");
				return false;
			}
		}
		System.out.println(n + " is prime!");
		return true;
	}
}

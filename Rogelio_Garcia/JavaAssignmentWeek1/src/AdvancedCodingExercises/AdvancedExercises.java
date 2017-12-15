package AdvancedCodingExercises;

import java.util.Calendar;
import java.util.Comparator;

import EasyCodingExercises.Employee;

public class AdvancedExercises {
	// 38
	public static String replaceChar(String target, char oldChar, char newChar) {
		return target.replace(oldChar, newChar);
	}
	//39 - test
	public static void happyBirthday(Calendar cal) {
		Calendar current = Calendar.getInstance();
		int currYear = current.get(Calendar.YEAR);
		int currMonth = current.get(Calendar.MONTH);
		int currDay = current.get(Calendar.DAY_OF_YEAR);
		int yourYear = cal.get(Calendar.YEAR);
		int yourMonth = cal.get(Calendar.MONTH);
		int yourDay = cal.get(Calendar.DAY_OF_YEAR);
		int diffYear = currYear - yourYear;
		int diffMonth = currMonth - yourMonth;
		int diffDay = currDay - yourDay;
		if (diffMonth == 0 && diffDay == 0) System.out.println("Happy Birthday!");
		else {
			System.out.println("You are " + diffYear + " years old.");
		}
	}
	
	// 40
	public static void fibIterative() {
		long fib1 = 0;
		long fib2 = 1;
		long temp = fib1 + fib2;
		System.out.print(fib2 + " ");
		for (int i = 0; i < 99; i++) {
			System.out.print(temp + " ");
			fib1 = fib2;
			fib2 = temp;
			temp = fib1 + fib2;
		}
		System.out.println();
	}
	public static void fibRecursive() {
		long[] memo = new long[101];
		fibRecursive(100, memo);
		for (int i = 0; i < memo.length; i++)
			System.out.print(memo[i] + " ");
		System.out.println();
	}
	private static long fibRecursive(int n, long[] memo) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		memo[n] = (memo[n-1] == 0 ? fibRecursive(n-1, memo) : memo[n-1]) + (memo[n-2] == 0 ? fibRecursive(n-2, memo) : memo[n-2]);
		return memo[n];
	}
	// 41
	public static void fizzBuzz() {
		for (int i = 1; i <= 50; i++) {
			if (i % 3 == 0 && i % 5 == 0) System.out.print("FizzBuzz ");
			else if (i % 3 == 0) System.out.print("Fizz ");
			else if (i % 5 == 0) System.out.print("Buzz ");
			else System.out.print(i + " ");
		}
		System.out.println();
	}
	// 42
	public class ByName implements Comparator<Employee> {
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	}
	public class ByDepartment implements Comparator<Employee> {
		public int compare(Employee e1, Employee e2) {
			return e1.getDept().compareTo(e2.getDept());
		}
	}
	public class ByAge implements Comparator<Employee> {
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	// 43
	public static boolean isArmstrong(int n) {
		int sum = 0;
		int temp = 0;
		int changingN = n;
		while (changingN > 0) {
			temp = changingN % 10;
			changingN = changingN / 10;
			sum += Math.pow(temp, 3);
		}
		if (sum == n) return true;
		return false;
	}
	// 44
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	// 45
	public static boolean isPrime(int n) {
		for (int i = 1; i < n; i++) {
			if (i == 1) continue;
			if (i == n) continue;
			if (n % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		fizzBuzz();
		fibIterative();
		fibRecursive();
		if (isArmstrong(123)) System.out.println("Armstrong!");
		else System.out.println("Not Armstrong.");
		System.out.println(reverse("Hello"));
		if (isPrime(11)) System.out.println(11 + " is Prime!");
		else System.out.println(11 + " is not Prime.");
	}
}

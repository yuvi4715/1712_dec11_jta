package com.revature.as1.adv;

import java.util.Calendar;

public class AdvDriver {
	
	public static void main(String[] args) {
		/*
		String s = "abcdbebfgb";
		
		System.out.println(StringMethods.replaceChar(s, 'b', 'A'));
		
		Calendar c = Calendar.getInstance();
		c.set(1994, Calendar.DECEMBER, 13); //Year, Month, Date - Month indexes from 0 so 11 == December
		
		BirthdayChecker.checkBirthday(c);
		
		Fibonacci.fibIterative();
		System.out.println("Next.");
		System.out.println("Rec Fib output: " + Fibonacci.fibRecursive(50));
		
		
		FizzBuzz.fizzBuzz();
		
		EmployeeComp e1 = new EmployeeComp(22, "Z", "SD");
		EmployeeComp e2 = new EmployeeComp(24, "A", "SS");
		EmployeeComp e3 = new EmployeeComp(22, "Z", "SD");
		
		SortByAge sa = new SortByAge();
		
		SortByDepartment sd = new SortByDepartment();
		
		SortByName sn = new SortByName();
		
		System.out.println("Comparing e1 to e2 by age shows that " + ((sa.compare(e1, e2) > 0) ? " e1 is older" : " e2 is older, or they're the same age"));
		
		System.out.println("e1 is equal to e2? " + e1.equals(e2));
		
		System.out.println("e1 is equal to e3? " + e1.equals(e3));
				
		System.out.println("Comparing e1 to e2 by name shows that " + ((sn.compare(e1, e2) > 0) ? " e1's name comes first in the alphabet" : " e2's name comes first alphabetically or they're the same name."));

		System.out.println("Comparing e1 to e2 by department shows that " + ((sd.compare(e1, e2) > 0) ? " e1's department name comes first in the alphabet" : " e2's depatment name comes first alphabetically or they're the same name."));
		*/
		
		int in = 153;
		
		System.out.println("Is " + in + " an Armstrong number? " + (Armstrong.checkArmstrong(in) ? "Yes" : "No"));
		
		System.out.println("Is " + in + " a prime number? " + (PrimeChecker.primeCheck(in) ? "Yes" : "No"));
		
		String rev = "A dog, a plan, a canal: pagoda.";
		
		System.out.println(StringMethods.reverseString(rev));

	}

}

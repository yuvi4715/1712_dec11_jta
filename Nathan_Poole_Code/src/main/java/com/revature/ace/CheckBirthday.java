package com.revature.ace;

/*
 * Nathan Poole
 * Question Thirty-nine
 * Write a method that takes a date of birth via Calendar object and returns your 
 * 		age. If it is your birthday, print the Happy Birthday song!
 */

import java.util.Calendar;

public class CheckBirthday {

	public static void main(String[] args) {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1995, 06, 26);
		
		System.out.println("I am "+checkAge(birthday)+" years old.");
		checkBirthday(birthday);
	}

	private static void checkBirthday(Calendar birthday) {

		Calendar today = Calendar.getInstance();
		int todayDay = today.get(Calendar.DAY_OF_MONTH);
		int birthDay = birthday.get(Calendar.DAY_OF_MONTH);
		int todayMonth = today.get(Calendar.MONTH); 
		int birthMonth = birthday.get(Calendar.MONTH);
		if(todayDay == birthDay && todayMonth == birthMonth) sing();

	}

	private static void sing() {

		System.out.println("Happy Birthday to You!");
		System.out.println("Happy Birthday to You!");
		System.out.println("Happy Birthday Dear ...");
		System.out.println("...");
		System.out.println("Wait...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("What was you name again?");

	}

	private static int checkAge(Calendar birthday) {

		Calendar today = Calendar.getInstance();
		int todayYear = today.get(Calendar.YEAR);
		int birthYear = birthday.get(Calendar.YEAR);
		return todayYear - birthYear;

	}
	
	
}

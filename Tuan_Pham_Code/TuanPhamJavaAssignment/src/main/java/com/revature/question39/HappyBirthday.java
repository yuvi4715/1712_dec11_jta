package com.revature.question39;

import java.text.SimpleDateFormat;
import java.util.*;

// Write a method that takes a date of birth via Calendar object and returns your age. If it is your birthday, print the Happy Birthday song!
public class HappyBirthday {
	
	public static int getAge() {
		Calendar cal = new GregorianCalendar();
		
		// Format the calendar to a simple format to compare dates 
		SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
		
		// Get the date today
		String currentDate = format1.format(cal.getTime());
		System.out.println("Current date is " + currentDate);
		
		String myBirthday = "02-22-1993";
		System.out.println("My birthday is " + currentDate);
		
		// If the date today is my birthday, print Happy Birthday
		if (currentDate.equals(myBirthday)) {
			System.out.println("Happy Birthday to You\r\n" + 
					"Happy Birthday to You\r\n" + 
					"Happy Birthday Dear Tuan\r\n" + 
					"Happy Birthday to You!");
		}
		
		// Calculate age by subtracting current year with birth year
		int currentYear = cal.get(Calendar.YEAR);
		int myAge = currentYear - 1993;
		
		System.out.print("My age is ");
		return myAge;
	}
	public static void main(String[] args) {
		System.out.println(getAge());
	}
}

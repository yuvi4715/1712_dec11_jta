package com.revature.day1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Number39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner Scanthing = new Scanner(System.in);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
	try {
		System.out.println("Enter your birthday, immediately. (dd-mm-yyyy)");
		String userDate = Scanthing.next();
		Date birthdate = myFormat.parse(userDate);
		
		Calendar dob = Calendar.getInstance(); //establish date of birth
		dob.setTime(birthdate);
		
		Scanthing.close();
		Calendar now = Calendar.getInstance(); //establish today's date
		
		int year1 = now.get(Calendar.YEAR); //quantify them
		int year2 = dob.get(Calendar.YEAR);
		int age = year1 - year2;
		int month1 = now.get(Calendar.MONTH);
		int month2 = dob.get(Calendar.MONTH);
		if (month2 > month1) {
			age--;
		} else if (month1 == month2) {
			int day1 = now.get(Calendar.DAY_OF_MONTH);
			int day2 = dob.get(Calendar.DAY_OF_MONTH);
			if (day2 > day1) {
				age--;
			}
			
			if (month1 == month2 && day1 == day2)
			{
				System.out.println("well happy birthday, son!");
			} else {
				System.out.println("you are " + age + " years old");
			}
		}
		
	} catch (ParseException e) {
		e.printStackTrace();
	}

}
}

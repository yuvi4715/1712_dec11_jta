package com.revature.week1.AdvancedCondingExercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalenderTest extends Calendar {

	// Calculate birthday age
	public static int ReturnAge(Date birthdate) {
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthdate);
		Calendar today = Calendar.getInstance();

		int yearDifference = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

		if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
			yearDifference--;
		} else {
			if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
					&& today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
				yearDifference--;
			}

		}

		return yearDifference;
	}

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the day of when you were born? ");
		int day = scan.nextInt();
		System.out.println("Enter the month of when you were born? ");
		int month = scan.nextInt();
		System.out.println("Enter the year of when you were born? ");
		int year = scan.nextInt();

		// Calculates my age for birthday
		if (day == 3 && month == 4 && year == 1992) {
			System.out.println("It was my birthday");
		}

		String birthdateStr = month + "-" + day + "-" + year;
		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		Date birthdate = df.parse(birthdateStr);
		System.out.println(CalenderTest.ReturnAge(birthdate));

	}

	@Override
	public void add(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub
		
	}

}

package com.revature.as1.adv;
import java.util.Calendar;

public class BirthdayChecker {
	
	public static void checkBirthday(Calendar d) {

		Calendar today = Calendar.getInstance();
		
		//System.out.println((today.get(Calendar.MONTH)));
		
		int curDay = today.get(Calendar.DAY_OF_MONTH);
		int bDay = d.get(Calendar.DAY_OF_MONTH);
		int curMonth = today.get(Calendar.MONTH);
		int bMonth = d.get(Calendar.MONTH);
		//System.out.println(curDay + " " + bDay);
		//System.out.println(curMonth + " " + bMonth);
		
		
		

		
		if((curDay == bDay) && (curMonth == bMonth)) {
			System.out.println("It's your Birthday!");
			System.out.println("Happy Birthday to You\nHappy Birthday to You");
		}
		
		int age = today.get(Calendar.YEAR) - d.get(Calendar.YEAR);
		
		if((curMonth <= bMonth) && (curDay > bDay)) {
			age--;
		}
		
		System.out.println("You are " + age + " years old!");
	}

}

package com.assignment1;

import java.util.Calendar;

public class Problem39 {
	
	public static int getAge(java.util.Date date)
	{
		Calendar today = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		
		dob.setTime(date);
		
		int todayYear = today.get(Calendar.YEAR);
	    int birthDateYear = dob.get(Calendar.YEAR);
	    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
	    int birthDateDayOfYear = dob.get(Calendar.DAY_OF_YEAR);
	    int todayMonth = today.get(Calendar.MONTH);
	    int birthDateMonth = dob.get(Calendar.MONTH);
	    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
	    int birthDateDayOfMonth = dob.get(Calendar.DAY_OF_MONTH);
	    int age = todayYear - birthDateYear;

	    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
	    if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
	        age--;
	    
	    // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
	    } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
	        age--;
	    }
	    
	    System.out.println(dob.getTime());
	    System.out.println(today.getTime());
	    if((today.DAY_OF_MONTH == dob.DAY_OF_MONTH) && (today.DAY_OF_WEEK == dob.DAY_OF_WEEK))
	    {
	    	System.out.println("Happy birthday!");
	    }
	    
	    return age;
		
	}
	
	public static void main(String[] args) {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1993, 11, 15);
		System.out.println("age: " + getAge(birthday.getTime())); 	}

}

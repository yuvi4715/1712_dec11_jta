package getasew.assignment1.advancedcoding;

import java.util.Calendar;
//39.Write a method that takes a date of birth via Calendar object and
// returns your age. If it is your birthday, print the Happy Birthday song!

public class BirthDayCalculator {

	public static void main(String[] args) {
		//instantiate the calendar object
		Calendar cal =  Calendar.getInstance();
		// saving the year,month,and date the instance.
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_MONTH);
		//setting the instance field's value to that  of birth day
		cal.set(1989, 11, 17);
	//calculate the age and display to the console
		int age;
		age = year - cal.get(Calendar.YEAR);
		System.out.printf("your age is %d",age);
		if((month == cal.get(Calendar.MONTH))&&(date==cal.get(Calendar.DAY_OF_MONTH))) {
			System.out.println("Happy Birth Day");
		}
	
		

	}

}

package AdvancedCodingExercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalenderObjects {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		getAge();

	}
	private static void getAge() throws ParseException {
		String birthday = "08-24-1991";
		
		Date bday = new SimpleDateFormat("MM-dd-yy").parse(birthday);
		Date today = new Date();
		
		Calendar todayCalendar = Calendar.getInstance(Locale.ENGLISH);
		Calendar bdayCalendar = Calendar.getInstance(Locale.ENGLISH);
		
		todayCalendar.setTime(today);
		bdayCalendar.setTime(bday);

		todayCalendar.setTimeInMillis(today.getTime());
		bdayCalendar.setTimeInMillis(bday.getTime());
		
		int result = todayCalendar.get(Calendar.YEAR) - bdayCalendar.get(Calendar.YEAR);
		System.out.println("You are " + result + " years old");
	}

}

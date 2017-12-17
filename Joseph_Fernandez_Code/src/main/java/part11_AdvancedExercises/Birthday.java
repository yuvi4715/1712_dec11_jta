package part11_AdvancedExercises;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Birthday {

	private Calendar bDay;
	
	public static void main(String[] args) {

//		System.out.println(GregorianCalendar.YEAR);
//		System.out.println(GregorianCalendar.DAY_OF_YEAR);
//		System.out.println(GregorianCalendar.MONTH);
		
		Calendar myBirthday = new GregorianCalendar(1994, 12, 15);	// GregorianCalendar accepts date in 'Year/Month/Day' format
		new Birthday(myBirthday);
	}

	public Birthday(Calendar birthDay) {
		this.bDay = birthDay;
		this.yourBirthDay(this.bDay);
	}

	public void yourBirthDay(Calendar bDay) {
		Calendar today = Calendar.getInstance();
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DAY_OF_MONTH);
		int year = today.get(Calendar.YEAR);
		
		int yourBirthMonth = bDay.get(Calendar.MONTH);
		int yourBirthDay = bDay.get(Calendar.DAY_OF_MONTH);
		int yourBirthYear = bDay.get(Calendar.YEAR);
		
		if((yourBirthMonth == month) && (yourBirthDay == day)) {
			System.out.println("HAPPY BIRTHDAY TO YOU!!! HAPPY BIRTHDAY TO YOU!!!");
		} else {
			System.out.println("It is NOT your Birthday, BUT you are " + (year - yourBirthYear) + " years old.");
		}
	}
}

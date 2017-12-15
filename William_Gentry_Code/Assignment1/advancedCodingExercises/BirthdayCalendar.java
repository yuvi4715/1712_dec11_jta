package advancedCodingExercises;
import java.util.*;

public class BirthdayCalendar {
	
	private Calendar yourBirthday;
	
	public BirthdayCalendar(Calendar yourBirthday) {
		this.yourBirthday = yourBirthday;
		this.yourAgeToday(this.yourBirthday);
	}

	public void yourAgeToday(Calendar birthday) {
		Calendar today = Calendar.getInstance();
		int theYearToday = today.get(Calendar.YEAR);
		int theDateToday = today.get(Calendar.DATE);
		int theMonthToday = today.getMaximum(Calendar.MONTH);
		
		int theYearYouWereBorn = birthday.get(Calendar.YEAR);
		int theDateYouWereBorn = birthday.get(Calendar.DATE);
		int theMonthYouWereBorn = birthday.get(Calendar.MONTH);
		
		if ((theMonthToday == theMonthYouWereBorn) && (theDateToday == theDateYouWereBorn)) {
			System.out.println("HAPPY BIRTHDAY!!!!");
			System.out.println("You are " + (theYearToday - theYearYouWereBorn) + " years old!");
		} else {
			System.out.println("You are " + (theYearToday - theYearYouWereBorn) + " years old!");

		}
	}
	
	public static void main(String[] args) {
		Calendar myBirthday = new GregorianCalendar(1995, 11, 12); //year, month, day
		new BirthdayCalendar(myBirthday);
	}
}

package advancedCodingExercises;

import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;

public class DateOfBirth39 {

	public static void main(String[] args) {
		Builder b = new Builder();
		b.setDate(1995, 4, 1);
		Calendar c = b.build();
		getAge(c);
	}
	
	public static void getAge(Calendar dob){
		Date date = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		String name = "Andrew";
		int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		boolean isSameMonth = now.get(Calendar.MONTH)==dob.get(Calendar.MONTH);
		boolean isSameDay = now.get(Calendar.DAY_OF_MONTH)==dob.get(Calendar.DAY_OF_MONTH);
		if(isSameMonth && isSameDay) {
			System.out.println("Happy birthday to you! Happy birthday to you! Happy birthday dear "+name+". Happy birthday to you.");
		}
		else if (now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		System.out.println("You are " + age + " years old now");
	}

}

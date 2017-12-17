package advancedcodingexcercises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Problem39 {

	public static void main(String[] args) {

		System.out.print("Please enter date of birth in MM-dd-yyyy: ");
		Scanner scanner = new Scanner(System.in);
		String input = null;
		try {
			input = scanner.nextLine();
			scanner.close();
			Calendar birth = new GregorianCalendar();
			Calendar today = new GregorianCalendar();
			int age = 0;
			int factor = 0; // to correctly calculate age when birthday has not been yet celebrated
			Date birthDate = new SimpleDateFormat("MM-dd-yyyy").parse(input);
			Date currentDate = new Date(); // current date

			birth.setTime(birthDate);
			today.setTime(currentDate);
			
			// check if birthday has been celebrated this year
			if (today.get(Calendar.DAY_OF_YEAR) == birth.get(Calendar.DAY_OF_YEAR)) {
				System.out.println("Happy Birthday to you. Happy Birthday to you. Happy Birthday, dear user. Happy Birthday to you!");
			}
			age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
			System.out.println("Age: " + age + " years old");
			scanner.close();
		} catch (ParseException e) {
			System.out.println("Enter a MM-DD-YYYY in the correct format. ");
		}

	}

}

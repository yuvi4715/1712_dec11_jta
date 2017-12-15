package question39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class GuessAge {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter month, day, and year (MM DD YYYY) of your birthday");
		String[] keystrokes = br.readLine().split(" ");
		
		int birthMonth = Integer.parseInt(keystrokes[0]);
		int birthDay = Integer.parseInt(keystrokes[1]);
		int birthYear = Integer.parseInt(keystrokes[2]);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int age = year - birthYear;
		if(birthMonth > month || (birthMonth == month && birthDay > day)) {
			age--;
		}
		System.out.printf("Your are %d years old", age);
		if(month == birthMonth && day == birthDay) {
			System.out.print("! Happy Birthday to you! Happy birthday to you! Happy birthday dear INSERT NAME HERE, happy birthday to you!");
		}
		
		
		
		
	}

}

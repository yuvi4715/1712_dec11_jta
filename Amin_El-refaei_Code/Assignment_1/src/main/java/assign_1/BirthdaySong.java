package assign_1; // this class contains the code for number 39

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class BirthdaySong {

	public static void main(String[] args) throws ParseException {
		birthDate(); // statically calling the birthDate method
	}
	
	public static void birthDate() throws ParseException {
	     
	    Calendar now = Calendar.getInstance(); // created a calendar instance named now

	    String today = (now.get(Calendar.MONTH) + 1 + "/" + now.get(Calendar.DATE)); // put now into a String for parsing purposes
	    
	    getBirthday(today); // calling getBirthday and passing today as the parameter
	     
	}
	
	public static void getBirthday(String today) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd"); // new simple date format
		Date d1 = sdf.parse("12/8"); // created a new date object called d1 and parsed it
		Date d2 = sdf.parse(today);
		
		if (d1.compareTo(d2) != 0) { // compares d1 and d2 and checks if it is 0
			System.out.println("Today is not your birthday");
		} else if (d1.compareTo(d2) == 0) {
			System.out.println(d2 + " Happy birthday to you\r\n " + "Happy birthday to you\r\n " + "Happy birthday to you\r\n " + "Happy birthday to you\r\n ");
		}
	}

}

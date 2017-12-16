import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
// Problem 39
public class BirthdaySong {
	 
	 
	  public static void main(String[] args) throws ParseException {
	    
	    //create Calendar instance
	    Calendar now = Calendar.getInstance();
	    // date formating
	  String currentDate = (
	                         now.get(Calendar.MONTH)+1
	                        + "-"
	                        + now.get(Calendar.DATE));	    
	  
	  getBirthday(currentDate);
	  }
	 
	  // created static method to return birthday song
	  // added SimpleDateFormat and Date to compare date format
	  // print based on the date1 variable - month and date format 
	    public static void getBirthday(String currentDate) throws ParseException {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date date1 = sdf.parse("12-15");
        Date date2 = sdf.parse(currentDate);
        if (date1.compareTo(date2) > 0 || date1.compareTo(date2) < 0) {
            System.out.println("Sorry but today is not your birthday " + date2);
        } else if (date1.compareTo(date2) == 0) {
        	 System.out.println(date2 + " Happy Birthday to You\r\n" + 
        	 		"Happy Birthday to You\r\n" + 
        	 		"Happy Birthday Dear (name)\r\n" + 
        	 		"Happy Birthday to You.\r\n" + 
        	 		"From good friends and true,\r\n" + 
        	 		"From old friends and new,\r\n" + 
        	 		"May good luck go with you,\r\n" + 
        	 		"And happiness too.\r\n" + 
        	 		"Alternative ending:\r\n" + 
        	 		"How old are you?\r\n" + 
        	 		"How old are you?\r\n" + 
        	 		"How old, How old\r\n" + 
        	 		"How old are you?");

	    
	  
	  }
	  
	  }
}


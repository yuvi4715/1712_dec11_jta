package getasew.assignment1.exceptions;

public class AlarmMain {
	public static void main(String[] args) {
		Alarm one = new Alarm();
		try {
			System.out.println("starting try block");
			System.exit(0);
			one.ringAlarm();
			System.out.println("Ending try block");
		} catch(AlarmMissingException e) {
			System.out.println("Starting catch block");
			System.out.println(e.getMessage());
			
		} finally {
			System.out.println("Alarm Stops");
		}
	}

}

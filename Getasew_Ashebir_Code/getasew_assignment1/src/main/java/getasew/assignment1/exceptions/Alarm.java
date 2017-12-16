package getasew.assignment1.exceptions;

public class Alarm {
	int timer = 0;
	public Alarm() {}
	public void ringAlarm() throws AlarmMissingException {
		timer++;
		System.out.println("Alarm is ringing");
		if(timer > 0) {
			throw new AlarmMissingException();
		} 
		
	}
}

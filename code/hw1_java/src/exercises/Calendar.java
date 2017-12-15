package exercises;

public class Calendar {
	int year;
	int month;
	int day;
	
	public Calendar(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getString() {
		return year + "/" + month + "/" + day;
	}
}

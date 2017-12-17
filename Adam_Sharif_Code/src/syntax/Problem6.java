package syntax;

public class Problem6 {

	public static void main(String[] args) {
		
		char value1 = 'M';

		if (value1 == 'S') {
			System.out.println("Found initial for last name Smith");
		} else if (value1 == 'M') {
			System.out.println("Found initial for last name Muna");

		} else {
			System.out.println("No matching initial for last name");
		}
		// switch statement
		String name = "Bob";
		switch (name) {
		case "Bob":
			System.out.println("Identified Bob!");
			break;
		case "Sue":
			System.out.println("Identified Sue!");
			break;
		case "Jeffrey":
			System.out.println("Identified Jeffrey!");
			break;
		default:
			System.out.println("Identification is invalid");
			break;
		}
		// while loop
		int int1 = 3;
		int int2 = 10;
		while (int1 < int2) {
			System.out.println("While loop is executing");
			int1++;
		}
		
		int num1 = 1;
		int num2 = 6;
		// do while loop
		do {
			System.out.println("Do while loop is executing");
			num1++;
		} while (num1 < num2);

		// for loop
		String[] colors = { "Red", "Orange", "Yellow", "Blue", "Purple", "Grey", "Green" };
		for (int i = 0; i < colors.length; i++) {
			System.out.println(colors[i]);
		}

	}

}

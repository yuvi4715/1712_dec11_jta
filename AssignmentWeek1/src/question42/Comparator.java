package question42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Comparator {
	public static void main(String[] args) throws IOException {
		//Employee b = new Employee("Sally", "Computers", 8);
		//Employee a = new Employee("Sally", "Computers", 8);
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter an employee's name, department, and age respectively");
		String[] keystrokes = br.readLine().split(" ");
		Employee a = new Employee
				(keystrokes[0], keystrokes[2], Integer.parseInt(keystrokes[2]));
		System.out.println("Enter a second employee for comparison");
		Employee b = new Employee
				(keystrokes[0], keystrokes[2], Integer.parseInt(keystrokes[2]));
		
		switch(Comparator.posNeg(a.name.compareToIgnoreCase(b.name))) {
		case 0:
			switch(Comparator.posNeg(a.department.compareToIgnoreCase(b.department))) {
			case 0:
				if(a.age > b.age) {
					System.out.printf("The names and department are the same but %s is greater than %s", a.age, b.age);
				}
				else if(a.age < b.age) {
					System.out.printf("The names and department are the same but %s is greater than %s", b.age, a.age);
				}
				else {
					System.out.println("The two entries are of the same person");
				}
				break;
			case 1:
				System.out.printf("The names are the same but the department name %s is greater than %s", a.department, b.department);
				break;
			case -1:
				System.out.printf("The names are the same but the department name %s is greater than %s", b.department, a.department);
				break;
			}
			break;
		case 1:
			System.out.printf("%s's name is greater than %s's", a.name, b.name);
			break;
		case -1:
			System.out.printf("%s's is greater than %s's", b.name, a.name);
			break;
		}
	}
	public static int posNeg(int number) {
		int temp;
		if(number > 0) {
			temp = 1;
		}
		else if(number < 0) {
			temp = -1;
		}
		else {
			temp = 0;
		}
		return temp;
	}
}



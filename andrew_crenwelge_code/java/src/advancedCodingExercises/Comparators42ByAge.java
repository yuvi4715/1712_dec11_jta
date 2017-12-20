package advancedCodingExercises;

import java.util.Comparator;

public class Comparators42ByAge implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 e1, Employee42 e2) {
		int age1 = e1.getAge();
		int age2 = e2.getAge();
		return age1 - age2;
	}
}

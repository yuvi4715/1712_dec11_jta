package advancedCodingExercises;

import java.util.Comparator;

public class Comparators42ByName implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 e1, Employee42 e2) {
		String name1 = e1.getName();
		String name2 = e2.getName();
		return name1.compareTo(name2);
	}
}

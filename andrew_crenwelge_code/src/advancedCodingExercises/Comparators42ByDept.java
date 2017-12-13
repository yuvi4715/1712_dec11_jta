package advancedCodingExercises;

import java.util.Comparator;

public class Comparators42ByDept implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 e1, Employee42 e2) {
		String name1 = e1.getDepartment();
		String name2 = e2.getDepartment();
		return name1.compareTo(name2);
	}
}

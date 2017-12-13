package advancedCodingExercises;

import java.util.Comparator;

public class ComparatorDemo42 {

	public static void main(String[] args) {
		/*
		 * Write Comparators to compare two employees based on their name, department, and age.
		 */
		
		// Our employee objects to compare
		Employee42 e1 = new Employee42("alice", "sales", 41);
		Employee42 e2 = new Employee42("bob", "hr", 35);
		
		// Get each comparator and compare
		Comparator<Employee42> cmp1 = new Comparators42ByName();
		Comparator<Employee42> cmp2 = new Comparators42ByDept();
		Comparator<Employee42> cmp3 = new Comparators42ByAge();
		System.out.println("By name: " + cmp1.compare(e1, e2));
		System.out.println("By name: " + cmp2.compare(e1, e2));
		System.out.println("By name: " + cmp3.compare(e1, e2));
	}
}

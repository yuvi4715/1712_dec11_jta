package com.revature.question42;

import java.util.Comparator;

// Write Comparators to compare two employees based on their name, department, and age.
public class AgeComparator implements Comparator<Employee> {

	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}

}

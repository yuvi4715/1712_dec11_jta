package com.revature.question42;

import java.util.Comparator;

// Write Comparators to compare two employees based on their name, department, and age.
public class NameComparator implements Comparator<Employee> {

	// Compare the two Employee names
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

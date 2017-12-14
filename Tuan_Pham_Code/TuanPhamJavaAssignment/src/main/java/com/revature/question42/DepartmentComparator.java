package com.revature.question42;

import java.util.Comparator;

// Write Comparators to compare two employees based on their name, department, and age.
public class DepartmentComparator implements Comparator<Employee> {

	// Compare two Employee departments
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}

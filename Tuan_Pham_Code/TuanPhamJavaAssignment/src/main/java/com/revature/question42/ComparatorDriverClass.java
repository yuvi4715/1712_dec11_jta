package com.revature.question42;

import java.util.ArrayList;
import java.util.Collections;

// Write Comparators to compare two employees based on their name, department, and age.
public class ComparatorDriverClass {

	public static void sort() {
		Employee e1 = new Employee("Tuan Pham", "IT", 24);
		Employee e2 = new Employee("John Smith", "HR", 30);
		Employee e3 = new Employee("Tony West", "Engineering", 22);
		Employee e4 = new Employee("Adam Brown", "Sales", 29);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		
		System.out.println("List of employees: ");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println("\nSort by employee name");
		Collections.sort(employeeList, new NameComparator());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println("\nSort by employee department");
		Collections.sort(employeeList, new DepartmentComparator());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println("\nSort by employee agename");
		Collections.sort(employeeList, new AgeComparator());
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		sort();
	}

}

package assign_1_comparators; // this class contains the code for number 42

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mainClass implements Comparator<Employee> { // implementing comparator

	public static void main(String[] args) {
		Employee emp2 = new Employee("Jeff", "Sales", 25); // created 2 new employee objects
		Employee emp1 = new Employee("Shawn", "HR", 32);

		ArrayList<Employee> employees = new ArrayList<Employee>(); // created an ArrayList to hold the employee objects

		employees.add(emp1); // adding employees to the ArrayList
		employees.add(emp2);

		System.out.println("This is the ArrayList of Employees before sorting");

		for (Employee e : employees) { // using an enhanced for loop to print employee names before sorting
			System.out.println(e.name);
		}

		Collections.sort(employees, new CompareByName()); // sorting the collection by name

		System.out.println("This is the ArrayList of Employees after sorting");

		for (Employee e : employees) {
			System.out.println(e.name); // enhanced for loop to print employees after sorting
		}

		System.out.println(employees);

	}

	public static class CompareByName implements Comparator<Employee> {

		@Override
		public int compare(Employee emp1, Employee emp2) { // overriding the compare method in comparator to compare
															// names
			return emp1.name.compareTo(emp2.name);
		}

	}

	public static class CompareByDept implements Comparator<Employee> {

		@Override
		public int compare(Employee emp1, Employee emp2) { // overriding the compare method in comparator to compare
															// departments
			return emp1.dept.compareTo(emp2.dept);
		}

	}

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp2.age - emp1.age; // overriding the compare method in comparator to compare age
	}

}

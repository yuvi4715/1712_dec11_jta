package advancedCodingExercises;

import java.util.*;

public class Employee {
	
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	static class EmployeeNameComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			String name1 = o1.getName();
			String name2 = o2.getName();
			
			return name1.compareTo(name2);
		}
	}
	
	static class EmployeeAgeComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			int age1 = o1.getAge();
			int age2 = o2.getAge();
			
			return age1-age2;
		}
	}
	
	static class EmployeeDepartmentComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			String dept1 = o1.getDepartment();
			String dept2 = o2.getDepartment();
			
			return dept1.compareTo(dept2);
		}
	}
	
	
	public static void main(String[] args) {
		Employee e1 = new Employee("William", "IT", 24);
		Employee e2 = new Employee("Roger", "Support", 28);
		Employee[] employees = {e1, e2};
		
		System.out.println("Comparing employees by Name");
		Arrays.sort(employees, new EmployeeNameComparator());
		for (int i = 0; i < employees.length; i++) {
			System.out.println("\t"+employees[i].getName());
		}
		System.out.println("\nComparing Employees by Age");
		Arrays.sort(employees, new EmployeeAgeComparator());
		for (int i = 0; i < employees.length; i++) {
			System.out.println("\t"+employees[i].getDepartment());
		}
		System.out.println("\nComparing Employees by Department");
		Arrays.sort(employees, new EmployeeDepartmentComparator());
		for (int i = 0; i < employees.length; i++) {
			System.out.println("\t"+employees[i].getAge());
		}
	}
	
}


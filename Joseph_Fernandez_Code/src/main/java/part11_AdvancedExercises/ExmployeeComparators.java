package part11_AdvancedExercises;

import java.util.Arrays;
import java.util.Comparator;

public class ExmployeeComparators {

	private String name;
	private String department;
	private int age;
	
	public ExmployeeComparators(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public static void main(String[] args) {
		ExmployeeComparators employee1 = new ExmployeeComparators("Joseph", "JTA Developer", 23);
		ExmployeeComparators employee2 = new ExmployeeComparators("Alex", ".NET Developer", 24);
		
		ExmployeeComparators[] employees = {employee1, employee2};
		
		System.out.println("-------- Name Comparison --------");
		Arrays.sort(employees, new EmployeeNameComparator());
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getName());
		}
		
		System.out.println();
		System.out.println("-------- Age Comparison --------");
		Arrays.sort(employees, new EmployeeAgeComparator());
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getDepartment());
		}
		
		System.out.println();
		System.out.println("-------- Department Comparison --------");
		Arrays.sort(employees, new EmployeeDepartmentComparator());
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getAge());
		}
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
	
	static class EmployeeNameComparator implements Comparator<ExmployeeComparators> {

		public int compare(ExmployeeComparators employee1, ExmployeeComparators employee2) {
			String name1 = employee1.getName();
			String name2 = employee2.getName();
			
			return name1.compareTo(name2);
		}
	}
	
	static class EmployeeAgeComparator implements Comparator<ExmployeeComparators> {
		
		public int compare(ExmployeeComparators employee1, ExmployeeComparators employee2) {
			int age1 = employee1.getAge();
			int age2 = employee2.getAge();
			
			return age1-age2;
		}
	}
	
	static class EmployeeDepartmentComparator implements Comparator<ExmployeeComparators> {
		
		public int compare(ExmployeeComparators employee1, ExmployeeComparators employee2) {
			String dept1 = employee1.getDepartment();
			String dept2 = employee2.getDepartment();
			
			return dept1.compareTo(dept2);
		}
	}
}

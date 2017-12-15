package exercises;

import java.util.Comparator;

public class Employee implements Comparator<Employee>, Comparable<Employee>{
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.age - e2.age;
	}

	@Override
	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);
	}
	
}

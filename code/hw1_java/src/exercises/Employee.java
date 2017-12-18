package exercises;

import java.util.Comparator;
import java.util.Objects;

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
	
	public int equals(Employee e) {	//#60
		if (this.name==e.name && this.department==e.department && this.age==e.age) {
			return 1;
		}
		return 0;
	}
	
	public int hashcode() {
		return Objects.hash(name, department, age);
	}
}

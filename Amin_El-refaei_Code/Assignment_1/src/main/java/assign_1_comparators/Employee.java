package assign_1_comparators; // this class contains code for number 42

public class Employee implements Comparable<Employee> {
	
	String name; // created some strings: name, dept, age
	String dept;
	int age;
	
	Employee(String name, String dept, int age) { // constructor for Employee objects
		this.name = name; 
		this.dept = dept;
		this.age = age;
	}



	public int compareTo(Employee emp2) { // if else statements to compare age
		if (this.age < emp2.age) { // if age is less than emp2 age, return -1
			return -1;
		} else if (this.age > emp2.age) {
			return 1;
		} else {
			return 0;
		}
	}


}

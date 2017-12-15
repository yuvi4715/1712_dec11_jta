package com.assignment1.problem42;

public class Employee implements Comparable<Employee>{
	String name;
	String department;
	int age;
	
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
	@Override
	public int compareTo(Employee o) {
		if( (this.getAge() == o.getAge()) )
			return 0;
		else if ( (this.getAge() > o.getAge() ) ) 
			return 1;
		else if ( (this.getAge() < o.getAge() ) )
				return -1;
		return 9;
	}
	
	public static void main(String[] args) {
		Employee c = new Employee("C", "C", 3);
		Employee a = new Employee("A", "D", 1);
		Employee b = new Employee("B", "B", 2);
		
		int i = a.compareTo(c);
		
		//System.out.println( a.getDepartment().compareTo(c.getDepartment()) );
		
		System.out.println(i);
		
		//there's a lot of ways to do this. I could just sort
			//based on one of the categories (age, dept, name) or
			// I could sort three times (by name, then sort by dept, then age)
			// I get the point so I'm just going to sort by age.
	}
	
}

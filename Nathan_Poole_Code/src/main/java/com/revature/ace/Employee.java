package com.revature.ace;

/*
 * Nathan Poole
 * Question Forty-two
 * Write Comparators to compare two employees based on their name, 
 * 		department and age
 */

public class Employee{

	private String name;
	private String department;
	private int age;
	
	public static void main(String[] args) {
		Employee em1 = new Employee("Harvy","Accounts Payable", 45);
		Employee em2 = new Employee("Jannet","Marketing", 23);
		Employee em3 = new Employee("Harvy","Accounts Payable", 45);
		//System.out.println(em1.getName() + ":"+em1.getDepartment() + ":"+em1.getAge());
		System.out.println(em1.compareTo(em2));
		//System.out.println();
		System.out.println(em1.compareTo(em3));
	}

	public boolean compareTo(Employee em2) {
		
		return (compareName(em2) && compareDept(em2) && compareAge(em2)); 
	}
	
	public boolean compareName(Employee em2) {
		return (name.equals(em2.getName()));
	}
	
	public boolean compareDept(Employee em2) {
		return(department.equals(em2.getDepartment()));
	}
	
	public boolean compareAge(Employee em2) {
		return(age == em2.getAge());
	}

	public Employee(String string, String string2, int age) { 
    	super();                                                             
		this.name = string;                                                    
		this.department = string2;                                        
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
	
	
}
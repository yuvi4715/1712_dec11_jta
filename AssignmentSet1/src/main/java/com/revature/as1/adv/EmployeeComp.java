package com.revature.as1.adv;

import java.util.Comparator;

public class EmployeeComp {
	
	private int age;
	private String name;
	private String department;
	
	
	
	public EmployeeComp() {
		super();
		age = 0;
		name = null;
		department = null;
		
	}
	
	public EmployeeComp(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	
	public boolean equals(EmployeeComp e2) {
		if(this.age - e2.getAge() != 0) {
			return false;
		}else if(!this.name.equals(e2.getName())) {
			return false;
		}else if(!this.department.equals(e2.getDepartment())) {
			return false;
		}
		return true;
	}
	

}

class SortByAge implements Comparator<EmployeeComp>{
    
	public int compare(EmployeeComp arg0, EmployeeComp arg1) {
		// TODO Auto-generated method stub
		return arg0.getAge() - arg1.getAge();
	}
}

class SortByDepartment implements Comparator<EmployeeComp>{
    
	public int compare(EmployeeComp arg0, EmployeeComp arg1) {
		// TODO Auto-generated method stub
		return arg0.getDepartment().compareToIgnoreCase(arg1.getDepartment());
	}
}

class SortByName implements Comparator<EmployeeComp> {
    
	public int compare(EmployeeComp arg0, EmployeeComp arg1) {
		// TODO Auto-generated method stub
		return  arg0.getName().compareToIgnoreCase(arg1.getName())*-1;	
	}
}
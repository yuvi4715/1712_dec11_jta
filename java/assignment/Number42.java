package com.revature.day1;

public class Number42 {
	
	String empname = "";
	String empdept = "";
	int empage = 0;
	
	
	public void Setemployee(String name, String dept, int age)
	{
		empname = name;
	    empdept = dept;
	    empage = age;	
	}
	
	public void compare(Number42 employee1, Number42 employee2)
	{
	if (employee1.empage < employee2.empage)
	{
		System.out.println("the first employee is younger than the second employee");
	} else if (employee1.empage == employee2.empage) 
		{
		System.out.println("these guys are the same age");
		} else {
			System.out.println("the second employee is younger");
		}
	
	if (employee1.empname.equals(employee2.empname))
	{
		System.out.println("these two people have the same name");
	}
	
	if (employee1.empdept.equals(employee2.empdept))
	{
		System.out.println("these two people work in the same department");
	}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Number42 emp1 = new Number42();
		Number42 emp2 = new Number42();
		
		emp1.Setemployee("Maurice", "IT", 33);
		emp2.Setemployee("Maurice", "IT", 33);
		
		emp1.compare(emp1, emp2);
	}

}

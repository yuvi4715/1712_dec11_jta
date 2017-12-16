package com.revature.week1.AdvancedCondingExercises;

public class Comparators {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Luke", "Jedi", 17);
		Employee e2 = new Employee("Darth", "Sith", 17);
		
		//comparing the two values
		boolean b1 = e1.getAge() == e2.getAge();
		boolean b2 = e1.getDepartment() == e2.getDepartment();
		boolean b3 = e1.getName() == e2.getName();
			
		//Comparing the two employees
		System.out.println("The ages are the same is " + b1);
		System.out.println("The departments are the same is " + b2);
		System.out.println("The names are not same is " + b3);
	    
	    


	}
}

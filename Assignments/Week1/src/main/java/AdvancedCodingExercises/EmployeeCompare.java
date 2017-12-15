package AdvancedCodingExercises;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employees employees[] = new Employees[2];
		
		employees[0] = new Employees();
		employees[0].setEmployeeName("William");
		employees[0].setEmployeeAge(25);;
		employees[0].setEmployeeDept("SoftwareDev");
		
		employees[1] = new Employees();
		employees[1].setEmployeeName("Jose");
		employees[1].setEmployeeAge(24);
		employees[1].setEmployeeDept("SoftwareDev");
				
		Arrays.sort(employees, new NameComparator());
				
		System.out.println("Sorting by names");
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Employee: " + employees[i].getEmployeeName() + " is " + employees[i].getEmployeeAge() + " years old"
					+ " and is a " + employees[i].getEmployeeDept());
		}
		
		System.out.println("Sorting by age");
		Arrays.sort(employees, new AgeComparator());
		
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println("Employee: " + employees[i].getEmployeeName() + " is " + employees[i].getEmployeeAge() + " years old"
					+ " and is a " + employees[i].getEmployeeDept());
		}
	}

}

class NameComparator implements Comparator<Employees>{

	@Override
	public int compare(Employees emp0, Employees emp1) {
		// TODO Auto-generated method stub
		String name1 = emp0.getEmployeeName();
		String name2 = emp1.getEmployeeName();
		return name1.compareTo(name2);
	}
}

class AgeComparator implements Comparator<Employees>{

	@Override
	public int compare(Employees o1, Employees o2) {
		// TODO Auto-generated method stub
		return o2.getEmployeeAge() - o1.getEmployeeAge();
	}
	
}


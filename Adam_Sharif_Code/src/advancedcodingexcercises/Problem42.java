package advancedcodingexcercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
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
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

}

class EmployeeChainedComparator implements Comparator<Employee> {

	private List<Comparator<Employee>> listComparators;

	public EmployeeChainedComparator(Comparator<Employee>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(Employee emp1, Employee emp2) {
		for (Comparator<Employee> comparator : listComparators) {
			int result = comparator.compare(emp1, emp2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}

class EmployeeDepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getDepartment().compareTo(emp2.getDepartment());
	}
}

class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getAge() - emp2.getAge();
	}
}


public class Problem42 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		 
        employees.add(new Employee("Mark", "Sales Department", 45));
        employees.add(new Employee("David", "Finance Deparment", 29));
        
        System.out.println("*** Before sorting:");
        
        for (Employee emp : employees) {
            System.out.println(emp);
        }
 
        Collections.sort(employees, new EmployeeChainedComparator( new EmployeeDepartmentComparator(),
                new EmployeeAgeComparator()));
        System.out.println("\n*** After sorting:");
        
        for (Employee emp : employees) {
            System.out.println(emp);
        }
 
    }

}



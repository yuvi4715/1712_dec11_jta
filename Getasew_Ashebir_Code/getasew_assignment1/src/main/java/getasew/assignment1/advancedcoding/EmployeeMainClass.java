package getasew.assignment1.advancedcoding;

public class EmployeeMainClass {
	public static void main(String[] args) {
		//instantiate the employee objects to compare
		EmployeeClass emp1 = new EmployeeClass("John",31,"Engineering");
		EmployeeClass emp2 = new EmployeeClass("George",26,"Engineering");
		System.out.println(compareEmployee(emp1,emp2));
		
		
	}
	//method that return true if two employee objects are equal and false otherwise
	public static boolean compareEmployee(EmployeeClass e1,EmployeeClass e2){
		if ((e1.getAge()==e2.getAge())&&((e1.getName()).equals(e2.getName()))&&((e1.getDepartment()).equals(e2.getDepartment()))) {
			return true;
		} else {
			return false;
		}
		
	}

}

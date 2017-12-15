package question24_25_26_27_28;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class FileIO {

	FileReader fr;
	BufferedReader br;
	Employee employeeObject;
	StringTokenizer variableSplit;
	
	HashMap<Integer, Employee> employeeObjectMap = new HashMap<Integer, Employee>();
	
	public void initFileRead() throws FileNotFoundException {
		fr = new FileReader("C:\\Users\\Robin\\Revature Workspace\\AssignmentWeek1\\src\\question24_25_26_27_28\\EmployeeList.txt");
		br = new BufferedReader(fr);
	}
	public void readObjectIntoHashMap() throws IOException {
		String tempEmp = br.readLine();
		do {
		variableSplit = new StringTokenizer(tempEmp,":");
		employeeObject = new Employee();
		employeeObject.setEmployeeID(Integer.parseInt(variableSplit.nextToken()));
		employeeObject.setFirstName(variableSplit.nextToken());
		employeeObject.setLastName(variableSplit.nextToken());
		employeeObject.setRole(variableSplit.nextToken());
		employeeObjectMap.put(employeeObject.getEmployeeID(), employeeObject);
		tempEmp = br.readLine();
		} while(!(tempEmp == null));
	}
	
	public void printHashMap() {
		employeeObjectMap.forEach((k,v)->System.out.println("Key: " + k + " Value: " + v.toString()));

	}
	
	
}

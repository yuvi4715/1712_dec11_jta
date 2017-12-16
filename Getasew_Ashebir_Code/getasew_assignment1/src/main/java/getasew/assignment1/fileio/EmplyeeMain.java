package getasew.assignment1.fileio;
/*
 * File I/O
Consider a text file has the following colon-separated lines:
Employee id:First Name:Last Name:Role
Read the file, and parse(tokenize) the fields using StringTokenizer with delimiter(:)
While parsing the file, place the information in an object, which should have four 
instance variables: Employee Id, First Name, Last Name, Role. 
Place these objects in a HashMap with the key as employee id and value as the object
i.e HashMap should have[
Key: 01 Value : Object representing first line
Key: the 02 Value: Object representing second line

 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class EmplyeeMain {

	public static void main(String[] args) throws IOException {

		BufferedReader inputstream = null;
		HashMap<String,Employee> hashList = new HashMap<String,Employee>();

		try {
			inputstream = new BufferedReader(new FileReader("employee.txt"));
			String st;
			while((st = inputstream.readLine()) != null) {
				placeInHashMap(createEmployeeObj(tokenizeString(st)),hashList);
				
		
			}

		} finally {
			if(inputstream != null) {
				inputstream.close();
			}
		}
		System.out.println(hashList.get("01").firstName);

		


	}
	public static Employee createEmployeeObj(String[] str) {
		Employee emp = new Employee(str[0],str[1],str[2],str[3]);
		return emp;
	}
	public static String[] tokenizeString(String str) {
		return str.split(":");
	}
	public static void placeInHashMap(Employee emp,HashMap<String,Employee> empMap) {
		empMap.put(emp.employeeId, emp);
		
	}

}

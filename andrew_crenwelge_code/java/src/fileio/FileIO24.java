package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO24 {
	/*
	 * Consider a text file has the following colon-separated lines: 
	 * 		Employee id:First Name:Last Name:Role 
	 * Read the file, and parse(tokenize) the fields
	 * using StringTokenizer with delimiter(:) While parsing the file, place the
	 * information in an object, which should have four instance variables: 
	 * 		Employee Id, First Name, Last Name, Role.
	 * Place these objects in a HashMap with the key as employee id and value 
	 * as the object i.e HashMap should have
	 * 		Key: 01 Value : Object representing first line 
	 * 		Key: the 02 Value: Object representing second line
	 */
	public static void main(String[] args) {
		FileIO24.parseFile();
	}

	private static void parseFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/resources/text.txt"));
			HashMap<String, Employee> empData = new HashMap<>();
			String l;
			while((l = br.readLine()) != null) {
				Employee emp = new Employee();
				StringTokenizer st = new StringTokenizer(l, ":");
				emp.setEmployeeID(st.nextToken());
				emp.setFirstName(st.nextToken());
				emp.setLastName(st.nextToken());
				emp.setRole(st.nextToken());
				empData.put(emp.getEmployeeID(), emp);
			}
			// see the hashmap
			System.out.println(empData.toString());
			// see all the individual values in the employee objects
			for (Employee e : empData.values()) {
				System.out.println(e.getEmployeeID());
				System.out.println(e.getFirstName());
				System.out.println(e.getLastName());
				System.out.println(e.getRole());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

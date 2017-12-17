package com.revature.fileIO;

/* 
 * Nathan Poole 
 * Question Twenty four to Twenty Eight
 * Consider a text file has the following colon-separated lines:
 * 
 * Employee id:First Name:Last Name:Role
 * 
 * Read the file, and parse(tokenize) the fields using StringTokenizer with 
 * 		delimiter(:)
 * 
 * While parsing the file, place the information in an object, which should 
 * 		have four instance variables: Employee Id, First Name, Last Name, Role. 
 * 
 * Place these objects in a HashMap with the key as employee id and value as 
 * 		the object
 * 		i.e HashMap should have
 * 			Key: 01 Value : Object representing first line
 * 			Key: 02 Value: Object representing second line

 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EmployeeIO {

	BufferedReader br = null;
	HashMap<String, Employee> employeeRoster = new HashMap<String, Employee>();
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		EmployeeIO myEmployees = new EmployeeIO();
		myEmployees.readFile();
	}

	void readFile() throws FileNotFoundException, IOException {
		br = new BufferedReader(new FileReader("src\\main\\resources\\YourFileHere.txt"));
		String info;
		while ((info = br.readLine()) != null) {
			parseTokens(info);
		}
	}

	void parseTokens(String Employee) {
		StringTokenizer splice = new StringTokenizer(Employee, ":");

		String employeeID = splice.nextToken();
		String firstName = splice.nextToken();
		String lastName = splice.nextToken();
		String role = splice.nextToken();

		Employee record = new Employee(employeeID, firstName, lastName, role);
		
		hashEmployee(record);
	}

	void hashEmployee(Employee e) {
	
		employeeRoster.put(e.getEmployeeID(), e);
	}

}

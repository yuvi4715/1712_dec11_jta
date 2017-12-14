package com.revature.week1_jason_shen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO {
	
	//  Questions 24-28	
	//	Consider a text file has the following colon-separated lines:
	//	Employee id:First Name:Last Name:Role
	//	Read the file, and parse(tokenize) the fields using StringTokenizer with delimiter(:)
	//	While parsing the file, place the information in an object, which should have four instance variables: Employee Id, First Name, Last Name, Role. 
	//	Place these objects in a HashMap with the key as employee id and value as the object
	//	i.e HashMap should have[
	//	Key: 01 Value : Object representing first line
	//	Key: 02 Value: Object representing second line

	public static void parseFile(String filename) throws Exception{
		BufferedReader inputStream = null;
//		File file = new File("C:\\Users\\Jason\\Documents\\GitHub\\1712_dec11_jta\\Jason_Shen_Code\\Week1\\Week1_Assignment\\src\\main\\resources\\fileio.txt");
		
		// This was such a huge pain to figure out...
		String path = new File("").getAbsolutePath();
		path = path.concat("/src/main/resources/" + filename);
//		System.out.println(path);
		
//		this line also works but i THINK the above is more proper
//		File file = new File("./src/main/resources/fileio.txt");
		File file = new File(path);
		
//		used for debugging--checks if file exists
//		System.out.println(file.getAbsoluteFile().exists());
//		System.out.println(file.exists());
		
		// Create HashMap to add employees too, was pretty hard to figure out the nested classes...
		HashMap<Integer, FileIO.Employee> employee_map = new HashMap<Integer, FileIO.Employee>();
		
		try {
			System.out.println("Reading file...");
			inputStream = new BufferedReader(new FileReader(file));
				
			
			String line;
			// Reads current line
			while((line = inputStream.readLine()) != null) {
				System.out.println(line);
				
				// Splits current line by token
				StringTokenizer tokenizer = new StringTokenizer(line, ":");
				
				// Creating new employee through the use of nested classes...
				FileIO.Employee curr_employee = new FileIO().new Employee();

				// Get each successive tokens and set the instance variables of the next employee to be added to HashMap
				// Not sure how to do this with loop...
				curr_employee.setId(Integer.parseInt(tokenizer.nextToken()));
				curr_employee.setFirstName(tokenizer.nextToken());
				curr_employee.setLastName(tokenizer.nextToken());
				curr_employee.setRole(tokenizer.nextToken());
				
				// Add current employee to hashmap
				employee_map.put(curr_employee.getId(), curr_employee);
				System.out.println(curr_employee.getFirstName() + " added to HashMap!");
				System.out.println("Updated HashMap: " + employee_map + "\n");
				
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			
			System.out.println("Resulting HashMap: " + employee_map);
		}
	}
	
	public class Employee {
		private int id;
		private String first_name;
		private String last_name;
		private String role;
		
		public Employee() {
			
		}
		
		public void setId(int x) {
			id = x;
			return;
		}
		
		public void setFirstName(String name) {
			first_name = name;
			return;
		}
		
		public void setLastName(String name) {
			last_name = name;
			return;
		}
		
		public void setRole(String r) {
			role = r;
			return;
		}
		
		public int getId() { 
			return this.id;
		}
		
		public String getFirstName() {
			return this.first_name;
		}
		
		public String getLastName() {
			return this.last_name;
		}
		
		public String getRole() {
			return this.role;
		}
	}
}

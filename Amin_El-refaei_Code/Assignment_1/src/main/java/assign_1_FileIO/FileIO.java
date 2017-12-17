package assign_1_FileIO; // this class contains the code for numbers 24-28

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO {

	static String i; // created a static string called

	public static void main(String[] args) {
		readBytes(); // statically calls readBytes() method

		StringTokenizer st1 = new StringTokenizer("1:Amin:El-refaei:Sales rep", ":"); // created a tokenizer to parse the string

		Employee emp1 = new Employee(Integer.parseInt(st1.nextToken()), st1.nextToken(), st1.nextToken(),
				st1.nextToken()); // created a new Employee object called emp1 and used the tokens from the tokenizer to pass its arguments
		
		System.out.println(emp1.empID);
		System.out.println(emp1.fName);
		System.out.println(emp1.lName);
		System.out.println(emp1.role);

		HashMap<Integer, String> employee = new HashMap<Integer, String>(); // created a new HashMap called Employee
		employee.put(emp1.empID, emp1.fName); // added the first key-value pair. key is empID and value is emp first name
		employee.put(emp1.empID, emp1.lName);
		employee.put(emp1.empID, emp1.role);
	}

	static void readBytes() { //readBytes method to read a text file
		try {
			String path = new File("").getAbsolutePath(); // calling getAbsolutePath on a new File
			path = path.concat("/src/main/resources/" + "InputData.txt"); // set the path
			File file = new File(path); // new file with the path as a parameter

			FileReader read = new FileReader(file); // created a new FileReader with the newly created file as a parameter
			BufferedReader fis = new BufferedReader(read); // created a BufferedReader named fis with file as a parameter
			while ((i = fis.readLine()) != null) { // while there is something in the file, print it
				System.out.println(i); 
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}

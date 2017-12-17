package part08_FileInputOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileInputOutput {
	
	BufferedReader br = null;
	public String fileName = "src\\main\\resources\\Employee.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new FileInputOutput().readWriteValues();
	}

	void readWriteValues() throws FileNotFoundException, IOException {
		
		br = new BufferedReader(new FileReader(fileName));
		HashMap<Integer, String> employee = new HashMap<Integer, String>();
		String str; 
		
		while ((str = br.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(str, ":");
			while(tokens.hasMoreTokens()) {
				int id = Integer.parseInt(tokens.nextToken().toString());
				String firstName = tokens.nextToken();
				String lastName = tokens.nextToken();
				String role = tokens.nextToken();

//				System.out.println(id + " :: " + firstName + " " + lastName + " :: " + role);
				
				// Entering the values in a HashMap where the id is the key and the firstName, lastName, and role are the value
				employee.put(id, firstName + " " + lastName + " :: " + role);
				
			}
		}
		
		System.out.println(employee);
		br.close();
	}
}

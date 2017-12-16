package com.revature.week1.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.revature.week1.Collections.Dog;

public class EmployeeTokenize {

	static Employee emp;

	public static void main(String[] arg) throws Exception {

		Map<String, String> one = new HashMap<String, String>();

		try {
			// Tokenizing the text file
			File f = new File("Employee.txt");
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			StringTokenizer st;
			s = br.readLine();

			// Putting the tokenizing values in the hashmap
			while (s != null) {
				int i = 0;
				String id = "";
				String first_name = "";
				String last_name = "";
				String role = "";
				st = new StringTokenizer(s, ":");
				while (st.hasMoreTokens()) {
					// System.out.println(st.nextToken());
					if (i == 0) {
						id = st.nextToken();
						System.out.println(id);
						i++;
					} else if (i == 1) {
						first_name = st.nextToken();
						System.out.println(first_name);
						i++;
					} else if (i == 2) {
						last_name = st.nextToken();
						System.out.println(last_name);
						i++;
					} else if (i == 3) {
						role = st.nextToken();
						System.out.println(role);
						i++;
					} else {
						i = 0;
					}
				}
				// System.out.println(" " + id + " " + first_name + " " + last_name + " " +
				// role);
				System.out.println("-----------------------------");
				emp = new Employee(id, first_name, last_name, role);
				one.put(emp.id, emp.getFirst_name());
				s = br.readLine(); // read the next line of the File
			}
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("File not found"); // if input file is missing...
		}

		// Printing out the hashmap
		for (Map.Entry<String, String> entry : one.entrySet()) {
			String key = entry.getKey();
			String e = entry.getValue();
			System.out.println("The id is " + key + ", and the first name is " + e);
		}
	}

}

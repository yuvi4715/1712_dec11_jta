package com.assignment1.problem24thru28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MainClass {

	public static void openAndParseFile() throws IOException {

		String line = null;
		FileReader fileReader = null;
		BufferedReader br = null;
		StringTokenizer st;
		try {
			fileReader = new FileReader("Employees.txt");
			br = new BufferedReader(fileReader);
			
			//i am using a String id for the sake of example, 
			//   int id is implemented for completion
			String id ="";
			//int id = 0;
			String firstName = "";
			String lastName = "";
			String role = "";
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line, ":");
				
				id = st.nextToken();
				//id = Integer.parseInt(a);
				firstName = st.nextToken();
				lastName = st.nextToken();
				role = st.nextToken();
				
				Employee e = new Employee(id, firstName, lastName, role);
				
				//Hashmap<Integer, String> hm
				HashMap<String,String> hm = new HashMap<String,String>();
				hm.put(e.getId(), e.getFirstName() + e.getLastName());
				System.out.println(hm);

			}
			
		} catch (FileNotFoundException e) {
			System.out.println("unable to open file");
			;
		} catch (IOException e) {
			System.out.println("io exception");
		} finally
		{
			br.close();
		}
	}
	

	public static void main(String[] args) throws IOException {
		openAndParseFile();
		
	}

}

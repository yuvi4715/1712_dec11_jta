package com.revature.day1;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Number24_to28 {

	String emp_id = "";
	String first_name = "";
	String last_name = "";
	String role = "";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Number24_to28 employee = new Number24_to28(); //create employee object
		
		
		//read employee info from file
		try {
			File myFile = new File("C:\\Users\\mauri\\Documents\\workspace-sts-3.9.1.RELEASE\\assignment1_Maurice\\src\\main\\java\\com\\revature\\day1\\empfile.txt");
			FileReader fileReader = new FileReader(myFile);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = reader.readLine(); //the info from the text is stored here
			String seperator = ":";
			StringTokenizer theString = new StringTokenizer(line, seperator);
			
			
		reader.close();
		
		//place read info into employee object; 4 instance variables
		
		String[] empinfo = new String[4];
		int x = 0;
		
		while (theString.hasMoreElements()) {
			System.out.println("attribute to be parsed to object: " + theString.nextElement());
		empinfo[x] = (String) theString.nextElement(); //theString object casted for storing in string array
		x++;
		}
		
		//try using Hash.values, then print something
		
		employee.emp_id = empinfo[0];
		employee.first_name = empinfo[1];
		employee.last_name = empinfo[2];
		employee.role = empinfo[3];
		
		//place these objects in a Hashmap
		
HashMap<String,String> empHash = new HashMap<String,String>();
		
		empHash.put(employee.emp_id, employee.first_name); 
		

	} catch(Exception ex) {
		ex.printStackTrace();
	}
	}

}

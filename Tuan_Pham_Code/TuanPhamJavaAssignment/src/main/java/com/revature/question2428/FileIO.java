package com.revature.question2428;

import java.io.*;
import java.util.*;

/*
Consider a text file has the following colon-separated lines:
Employee id:First Name:Last Name:Role
Read the file, and parse(tokenize) the fields using StringTokenizer with delimiter(:)
While parsing the file, place the information in an object, which should have four instance variables: Employee Id, First Name, Last Name, Role. 
Place these objects in a HashMap with the key as employee id and value as the object
HashMap should have[
Key: 01 Value : Object representing first line
Key: 02 Value: Object representing second line
 */
public class FileIO {

	public static void readFile() throws Exception {
		// Create HashMap to hold EmployeeID, Object that holds the information
		HashMap<Integer, Object> myMap = new HashMap<Integer, Object>();
		
		// Use BufferedReader to read my file that contains information in format of Employee id:First Name:Last Name:Role
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("myFile.txt"));
			
			String read;
			while ((read = br.readLine()) != null) {
				// Split the read line by the delimiter :
				StringTokenizer token = new StringTokenizer(read,":");
				
				while(token.hasMoreTokens()) {
					// Create an Object(EmployeeID, FirstName, LastName, Role) to store the tokens
					// Uses the class FileIOObject and assumes the EmployeeID is an integer
					FileIOObject fo = new FileIOObject(Integer.parseInt(token.nextToken()), token.nextToken(), token.nextToken(), token.nextToken());
					
					// Insert the Object into HashMap using the Object EmployeeID as key and the Object itself as the value
					myMap.put(fo.EmployeeID, fo);
				}
			}
		} catch(Exception e) {
			
		} finally {
			// Close the BufferedReader
			br.close();
		}
		
		// Print out the values of the HashMap for testing
		Set<Integer> keys = myMap.keySet();
		for (int key : keys) {
			System.out.println(key + ", " + myMap.get(key));
		}
	}
	public static void main(String[] args) throws Exception {
		readFile();
	}

}

package com.revature.as1.fileio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EmployeeLoader {
	
	public static HashMap<Integer, Employee> loadEmployees(String filePath){
		//returns null on an error, returns an Employee HashMap otherwise, with EmployeeID as the key
		
		Scanner sc = null;
		HashMap<Integer, Employee> out = new HashMap<Integer, Employee>();
		try {
			System.out.println("Entering try.");
			//ClassLoader cL = .getClass().getClassLoader();
			//System.out.println("Created ClassLoader.");
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream is = loader.getResourceAsStream(filePath);
			sc = new Scanner(is).useDelimiter("\\n");
			System.out.println("Opened input stream.");
			String curLine;
			
			
			while(sc.hasNext()) {
				curLine = sc.nextLine();
				StringTokenizer st = new StringTokenizer(curLine, ":");
				Employee emp = new Employee(Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken());
				out.put(emp.getEmployeeID(), emp);		
			}		
			
			
		}catch(Exception e) {
			System.out.println("Something went wrong. Error: " + e.getMessage());
			e.printStackTrace();
			out = null;
		}finally {
			sc.close();
			return out;
		}
		
	}

}

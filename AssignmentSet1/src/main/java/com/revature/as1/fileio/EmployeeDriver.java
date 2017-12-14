package com.revature.as1.fileio;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDriver {
	
	public static void main(String[] args) {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		HashMap<Integer, Employee> eHashMap = EmployeeLoader.loadEmployees("employeeinfo.txt");
		
		
		
		for(Map.Entry<Integer,Employee> cs : eHashMap.entrySet()) {
			System.out.println("Employee Map Entry: " + cs.getKey() + ". Employee Info: " + cs.getValue().toString());
		}
	}

}

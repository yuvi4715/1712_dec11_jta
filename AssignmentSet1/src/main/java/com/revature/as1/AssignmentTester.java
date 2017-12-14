package com.revature.as1;

public class AssignmentTester {
	public static void main(String[] args) {
		TestableProject tester = new Project6(); //To testrun a project, replace the * in "new Project*()" with the Project number
		
		tester.setup();
		tester.test();
		
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}
}
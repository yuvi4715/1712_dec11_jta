package com.revature.week1.AdvancedConcepts;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		// check the number of processors available
		int processors = runtime.availableProcessors();
		System.out.println(processors);
		
		//gets the totalmemory of the JVM
	    double totalMemory = runtime.totalMemory();
	    System.out.println("The total memory in" + totalMemory);
	
		//halts the JVM
		System.out.println("Program starting...");
		runtime.exit(0);
	    System.out.println("Program still running...");

	}
}

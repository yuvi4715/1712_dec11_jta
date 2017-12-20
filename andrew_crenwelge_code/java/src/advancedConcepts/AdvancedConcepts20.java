package advancedConcepts;

public class AdvancedConcepts20 {
	public static void main(String[] args) {
		/*
		 * Create a Runtime object and note at least three methods. 
		 * Imagine how you would use them
		 */
		
		// get a runtime object
		Runtime runTimeObj = Runtime.getRuntime();
		// get the number of processors available to the JVM
		System.out.println("available processors: " + runTimeObj.availableProcessors());
		// get the amount of memory available
		System.out.println("available memory: " + runTimeObj.freeMemory());
		// call the garbage collector
		System.out.println("calling the garbage collector...");
		runTimeObj.gc();
		// we can see how much memory we've freed up
		System.out.println("available memory: " + runTimeObj.freeMemory());
	}

}

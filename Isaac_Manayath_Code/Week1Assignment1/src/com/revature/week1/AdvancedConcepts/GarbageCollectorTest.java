package com.revature.week1.AdvancedConcepts;

public class GarbageCollectorTest {

	public static void main(String[] args) {
		
		GarbageCollectorTest test1 = new GarbageCollectorTest();
		System.out.println("Created one object");
		test1 = null;
		
		System.out.println("Object is emppty");
		
		//running garbage collection
		System.gc();
		
		System.out.println("Ran garbage collection which collected the unused object");
	}
}

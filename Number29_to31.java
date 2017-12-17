package com.revature.day1;

import java.util.Iterator;
import java.util.TreeSet;



public class Number29_to31 implements Runnable {

	private Thread t;
	private String threadName;
	TreeSet threadSet = new TreeSet(); //thread adds ints to this set
	int a = 0; //variable for storing ints
	
	
	Number29_to31( String name) {
		threadName = name;
		System.out.println("creating " + threadName );
	}
	
	
	public void run() {
		System.out.println("Running " + threadName);
		
		try {
			//thread method code
			for(int i = 1; i < 1000; i++) {
				System.out.println("thread is working");
				storething(a); //store int in collection and increment it
				
				
				Thread.sleep(50); //other methods: sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll() 
			}
		//print out all of set, once gathered and stored
			System.out.println("Iterating over list:");
			Iterator<Integer> h = threadSet.iterator();
			while (h.hasNext())
				System.out.println(h.next());
		
	} catch (InterruptedException e) {
		System.out.println("thread " + threadName + " interrupted.");
		}
		System.out.println("Thread exiting.");
	}	
	

	
	public void start()
	{
		System.out.println("starting thread");
		if (t == null)
		{
			t = new Thread (this, threadName); //how to parse data to this thread's method from main?
			t.start();
		}
	}
	
	public void storething(int b)
	{
		synchronized(this) { //synchronizing causes output between threads to run more contiguously
		threadSet.add(b);
		a++; //each time the method is called, a increases by 1
	
	System.out.println(b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Number29_to31 T1 = new Number29_to31("1st Thread");
		T1.start();
		Number29_to31 T2 = new Number29_to31("2nd Thread");
		T2.start();
		Number29_to31 T3 = new Number29_to31("3rd Thread");
		T3.start();
		
	}

}

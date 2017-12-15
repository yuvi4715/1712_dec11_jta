package com.revature.question2931;

import java.util.TreeSet;

/*
Write a method that stores an integer. Each time the method is called, increment the integer by 1. Create three threads that call this method 1000 times each, storing the returned result in their own set. Print out each thread’s set.
Synchronize the method that stores and increments the integer. Execute your threads again.
Review thread-specific methods: sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll()
*/
public class MultiThread extends Thread{

	private Thread t;
	private String threadName;
	private int count;
	
	// Create a thread with a name for the thread along with a number to increment 1000 times
	MultiThread(String name, int incCount) {
		threadName = name;
		count = incCount;
		System.out.println("Creating " + threadName);
	}
	
	// Loop for 1000 times and each time, call the increment method 
	// When it's finished, add the result to a TreeSet to be stored and printed
	public void run() {
		System.out.println("Running " + threadName); 
		try {
			for (int i = 0; i < 1000; i++) {
				incrementInteger(count);
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted");
		}
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(count);
		for (int e : ts) System.out.println(threadName + " result set:" + e);
		System.out.println("Thread "  + threadName + " exiting");
		
	}
	
	// Whenever the thread is created, print status and run
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	// Synchronize the method so that there are no race conflicts when three threads are incrementing at the same time
	public synchronized void incrementInteger(int counter) {
		this.count = counter;
		count+=1;
	}
	
	/*
	 * sleep() - This makes the thread to stop or "sleep" for a specified amount of time in milliseconds
	 * wait() - Makes the thread wait until it is called again using notify
	 * yield() - Notify the system that the thread is willing to let another thread go
	 * suspend() - Puts the thread on lock and is extremely dangerous to use as it is prone to deadlock
	 * stop() - Stops the thread by unlocking all monitors it locked
	 * resume() - Resumes the thread after using suspend
	 * interrupt() - Interrupts the thread
	 * notify() - Wakes up a thread that is currently waiting
	 * notifyAll() - Wakes up all threads that are waiting 
	 */
	public static void main(String[] args) {
		MultiThread T1 = new MultiThread("Thread 1", 50);
		T1.start();
		
		MultiThread T2 = new MultiThread("Thread 2", 100);
		T2.start();
		
		MultiThread T3 = new MultiThread("Thread 3", 0);
		T3.start();
	}
}

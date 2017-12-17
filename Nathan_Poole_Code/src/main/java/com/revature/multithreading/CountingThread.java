package com.revature.multithreading;


/*
 * Nathan Poole
 * Questions Twenty-nine through Thirty-one
 * 
 * Write a method that stores an integer. Each time the method is called, 
 * 		increment the integer by 1. Create three threads that call this 
 * 		method 1000 times each, storing the returned result in their own set. 
 * 		Print out each thread’s set.
 * 
 * Synchronize the method that stores and increments the integer. Execute 
 * 		your threads again.
 * 
 * Review thread-specific methods: sleep(), wait(), yield(), suspend(), stop(), 
 * 		resume(), interrupt(), notify(), notifyAll()
 */
public class CountingThread extends Thread{
	
	int counter = 0;
	int total = 0;
	
	public static void main(String[] args) {
		CountingThread ct1 = new CountingThread();
		CountingThread ct2 = new CountingThread();
		CountingThread ct3 = new CountingThread();
		ct1.start();
		ct2.start();
		ct3.start();
	}
	
	@Override
	public void run() {
		for(int i =0; i<1000; i++) storeIncrementCounter();
		System.out.println(total);
	}

	private synchronized void storeIncrementCounter() {
		total += counter++;
	}
	
	/*
	 * sleep() forces a thread to wait for a specified amount of time
	 * wait() causes a thread to wait until it receives a signal to resume from another thread
	 * yield() suggests to the scheduler to switch to a different thread.
	 * suspend() suspends a thread until it is resumed or terminated
	 * stop() forces a thread to stop whatever it is doing and throw a ThreadDeath exception object.
	 * resume() resumes a suspended thread if it is still alive
	 * interrupt() interrupts a thread
	 * notify()	notify a waiting thread to resume
	 * notifyAll() notify all waiting threads to resume
	 */
	
}

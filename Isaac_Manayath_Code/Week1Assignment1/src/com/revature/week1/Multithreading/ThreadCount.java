package com.revature.week1.Multithreading;

public class ThreadCount implements Runnable {

	private Thread t;
	private String threadName;
	int count = 0;

	ThreadCount(String name) {

		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {

	/*	System.out.println("Running +" + threadName);
		for (int i = 0; i < 5; i++) {
			count();
		}*/

	}

	public void start() {
		System.out.println("Starting +" + threadName);
		for (int i = 0; i < 1000; i++) {
			count();
		}

	}

	public static void main(String[] args) {
		ThreadCount t1 = new ThreadCount("t1");
		t1.start();

		ThreadCount t2 = new ThreadCount("t2");
		t2.start();

		ThreadCount t3 = new ThreadCount("t3");
		t3.start();

	}

	public void count() {
		count++;
		System.out.println(count + " " + threadName);
	}
}

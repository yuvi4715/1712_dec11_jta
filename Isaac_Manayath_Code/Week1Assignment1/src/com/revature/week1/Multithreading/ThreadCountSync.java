package com.revature.week1.Multithreading;

public class ThreadCountSync implements Runnable {

	private Thread t;
	private String threadName;
	int count = 0;

	ThreadCountSync(String name) {

		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {

	/*	System.out.println("Running +" + threadName);
		for(int i = 0; i<5;i++) {
			count();
		}*/
		
		
	}

	public void start() {
		System.out.println("Starting +" + threadName);
		for(int i = 0; i<1000;i++) {
			count();
		}
		
	}

	public static void main(String[] args) {
		ThreadCountSync t1 = new ThreadCountSync("t1");
		t1.start();

		ThreadCountSync t2 = new ThreadCountSync("t2");
		t2.start();
		
		ThreadCountSync t3 = new ThreadCountSync("t3");
		t3.start();

	}
	public synchronized void count() {
		count++;
		System.out.println(count + " " + threadName);
	}
}
	
	


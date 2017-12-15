package com.revature.question50;

// Write a program that creates deadlock between two threads.
public class Deadlock extends Thread {

	private static Thread t;
	private static String threadName;
	public static String deadLock1 = "deadLock1";
	public static String deadLock2 = "deadLock2";

	public static void main(String[] args) {
		Deadlock1 T1 = new Deadlock1("Thread 1");
		Deadlock2 T2 = new Deadlock2("Thread 2");
		T1.start();
		T2.start();
	}

	public static class Deadlock1 extends Thread {
		public Deadlock1(String name) {
			threadName = name;

			System.out.println("Creating " + threadName);
		}

		public void run() {
			System.out.println("Running " + threadName);
			synchronized (deadLock1) {
				System.out.println("Thread 1: Holding lock 1...");
				synchronized (deadLock2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
					System.out.println(deadLock1 + deadLock2);
				}
			}
			try {
			} catch (Exception e) {
				System.out.println("Thread " + threadName + " interrupted");
			}
			System.out.println("Thread " + threadName + " exiting");
		}

		// Whenever the thread is created, print status and run
		public void start() {
			System.out.println("Starting " + threadName);
			if (t == null) {
				t = new Thread(this, threadName);
				t.start();
			}
		}
	}

	public static class Deadlock2 extends Thread {
		public Deadlock2(String name) {
			threadName = name;

			System.out.println("Creating " + threadName);
		}

		public void run() {
			System.out.println("Running " + threadName);
			synchronized (deadLock2) {
				System.out.println("Thread 2: Holding lock 2");
				synchronized (deadLock1) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
					System.out.println(deadLock1 + deadLock2);
				}
			}
			try {
			} catch (Exception e) {
				System.out.println("Thread " + threadName + " interrupted");
			}
			System.out.println("Thread " + threadName + " exiting");
		}

		// Whenever the thread is created, print status and run
		public void start() {
			System.out.println("Starting " + threadName);
			if (t == null) {
				t = new Thread(this, threadName);
				t.start();
			}
		}
	}
}

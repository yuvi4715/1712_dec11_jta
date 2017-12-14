package com.revature.as1.multithreading;

import java.util.ArrayList;

public class ThreadedIncrementer implements Runnable {
	/*
	 * Thread methods: sleep() - the thread pauses for a certain offset of time but
	 * does not release locks it holds wait() - like sleep, but can be woken with
	 * notifies. Releases locks. yield() - ends the threads current timeslice.
	 * Relies on OS system calls, and thus behaves differently on different systems.
	 * Should be avoided. suspend() - pauses the current thread until resume() is
	 * called. Depreciated as it holds onto locks. notify() - wakes up a thread that
	 * is waiting notifyAll() - wakes up all threads waiting stop() - stops current
	 * thread and instantly releases all locks. Depreciated as the release process
	 * is not state-safe.
	 * 
	 */

	private static int numThreads = 0; // Total number of threads
	private int threadNum; // Number of this thread
	private Thread t;
	private ArrayList<Integer> internalSet;
	private static int counter = 0;

	public ThreadedIncrementer() {
		numThreads++;
		threadNum = numThreads;
		internalSet = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			try {

				incrementCounter();

			} catch (InterruptedException e) {

				System.out.println("Interrupted!");

			}
			internalSet.add(counter);
		}

		printInternalSet();
	}

	public void printInternalSet() {
		StringBuilder s = new StringBuilder("");
		s.append("Internal set of thread " + threadNum + ": ");
		for (int i : internalSet) {
			s.append(i + " ");
		}
		System.out.println(s);
	}

	private synchronized void incrementCounter() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized ((Integer) counter) {
			counter++;
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, Integer.toString(threadNum));
			t.start();
		}
	}

	public int getThreadNumber() {
		return threadNum;
	}

}

package question29_30_31;

import java.util.Arrays;

public class Multithreading implements Runnable {

	Thread[] threadID = new Thread[3];
	public int process;
	int[] processList1 = new int[1000];
	int[] processList2 = new int[1000];
	int[] processList3 = new int[1000];

	/*
	 * When unsynchronized, each thread is working on the same method at the same
	 * time. Thus, each thread runs concurrently incrementing the "process" integer
	 * and storing it in their respective buffer. This also gives room for race
	 * conditions. When race conditions occur, the "process" integer is being
	 * accessed at the same time by multiple threads. Because of this, multiple
	 * threads may record the same number because it hasn't been updated or the
	 * multiple threads update "process" many times effectively skipping numbers
	 * altogether.
	 */
	public void unsynchronizedStoreID() {
		for (int i = 0; i < 1000; i++) {
			saveProcess(process++, i, getID());
		}

	}

	/*
	 * When synchronized, only one thread can perform the method at a time. Because
	 * of this, one thread will record and increment "process" giving an ordered
	 * buffer per thread.
	 */
	public synchronized void synchronizedStoreID() {
		for (int i = 0; i < 1000; i++) {
			saveProcess(process++, i, getID());
		}

	}

	public int getID() {
		int tempID = 3;
		for (int i = 0; i < threadID.length; i++) {
			if (Thread.currentThread() == threadID[i]) {
				tempID = i;
				break;
			}
		}
		return tempID;
	}

	public synchronized void setID() {
		if (threadID[0] == null) {
			threadID[0] = Thread.currentThread();
		} else if (threadID[1] == null) {
			threadID[1] = Thread.currentThread();
		} else {
			threadID[2] = Thread.currentThread();

		}
	}

	public void saveProcess(int process, int index, int threadID) {
		switch (threadID) {
		case 0:
			processList1[index] = process;
			break;
		case 1:
			processList2[index] = process;
			break;
		case 2:
			processList3[index] = process;
			break;
		}
	}

	public synchronized void printProcessList(int threadID) {

		System.out.printf("Thread %d: ", threadID + 1);

		switch (threadID) {
		case 0:
			System.out.print(Arrays.toString(processList1));
			break;
		case 1:
			System.out.print(Arrays.toString(processList2));
			break;
		case 2:
			System.out.print(Arrays.toString(processList3));
			break;
		}
		System.out.println();
	}

	/*
	 * work on it later
	 */
//	public void organizePrint() {
//		try {
//			synchronized (this.threadID) {
//				if (this.threadID[0] == Thread.currentThread()) {
//					printProcessList(getID());
//					this.threadID.notifyAll();
//					
//					return;
//				} else {
//					this.threadID.wait();
//				}
//				if (this.threadID[1] == Thread.currentThread()) {
//					printProcessList(getID());
//					this.threadID.notifyAll();
//					return;
//				} else {
//					this.threadID.wait();
//				}
//			}
//		} catch (InterruptedException e) {
//		}
//	}

	public void run() {
		try {
			synchronized (threadID) {
				if (threadID[0] == null) {
					threadID[0] = Thread.currentThread();
					threadID.wait();
				} else if (threadID[1] == null) {
					threadID[1] = Thread.currentThread();
					threadID.wait();
				} else {
					threadID[2] = Thread.currentThread();
					threadID.notifyAll();
				}
			}
		} catch (InterruptedException e) {
		}

		synchronizedStoreID();
		printProcessList(getID());
		//organizePrint();

	}

}

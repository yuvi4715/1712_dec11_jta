package com.revature.threads;

public class TestThreads {

	public static void main(String[] args) {
		ExtendThreadClass t1 = new ExtendThreadClass("thread1");
		t1.start();
		ExtendThreadClass t2 = new ExtendThreadClass("thread2");
		t2.start();
		
//		ImplementRunnable t3 = new ImplementRunnable();
//		ImplementRunnable t4 = new ImplementRunnable();
//		t3.start();
//		t4.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

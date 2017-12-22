package com.revature.threads;

public class ExtendThreadClass extends Thread {
	
	String threadName;
	public ExtendThreadClass(String threadName) {
		this.threadName = threadName;
		System.out.println("constructor " + this.getState());
	}
	
	@Override
	public synchronized void run() {
		for (int i=0; i<20; i++) {
			try {
				Thread.sleep(300);
				//System.out.println(i  + Thread.currentThread().getName());
				System.out.println(this.threadName + " : " + this.getId() + " : " + this.getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(this.getState());
			}
		}
	}
	
}

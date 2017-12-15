package com.revature.threads;

public class ImplementRunnable implements Runnable {

	
	@Override
	public synchronized void run() {
		for (int i=0; i<20; i++) {
			try {
				Thread.sleep(300);
				System.out.println(i  + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		run();
	}

}

package com.revature.week1_jason_shen;

//import java.util.concurrent.atomic.AtomicInteger;

public class  MultithreadingSynced implements Runnable {

	private int thread_run_count;
	private static int total_run_count = 0; 
	private String thread_name;
	
	public MultithreadingSynced(String name) {
		thread_name = name;
		System.out.println("Creating " + thread_name);
	}

	private void update_run_counts() {
		this.thread_run_count += 1;
//		System.out.println("Thread " + thread_name + " run count: " + thread_run_count);
		
		total_run_count+=1;
//		System.out.println("Total run count: " + total_run_count + "\n");
		return;
	}			
	
	public synchronized void run() {

		System.out.println("Running thread " + thread_name);
		try {
			for (int i = 0; i < 1000; i++) {
				this.update_run_counts();
			}
		
		} catch (Exception e) {
			System.out.println("Thread " + thread_name + " was interrupted.");
		} finally {
			System.out.println("Thread " + thread_name + " run count: " + this.thread_run_count);
			System.out.println("Total run count: " + total_run_count + " (" + thread_name +  " ending)");
		}

	}
	
	public void start() {
		run();
	}
	
	public int getTotalRunCOunt() {
		return total_run_count;
	}
}

package com.revature.week1_jason_shen;

public class Multithreading implements Runnable {

	private Thread t;
	private int thread_run_count;
	private static int total_run_count = 0; 
	private String thread_name;
	
	public Multithreading(String name) {
		thread_name = name;
		System.out.println("Creating " + thread_name);
	}

	private void update_run_counts() {
		this.thread_run_count += 1;
//		System.out.println("Thread " + thread_name + " run count: " + thread_run_count);
		
		total_run_count += 1;
//		System.out.println("Total run count: " + total_run_count + "\n");
		return;
	}	
	
	public void run() {

		System.out.println("Running thread " + thread_name);
		try {
			for (int i = 0; i < 1000; i++) {
				this.update_run_counts();
			}
		
		} catch (Exception e) {
			System.out.println("Thread " + thread_name + " was interrupted.");
		} finally {
			System.out.println("Thread " + thread_name + " run count: " + this.thread_run_count);
			System.out.println("Total run count: " + total_run_count + " (" + thread_name +  " ending)\n");
		}

	}
	
	public void start() {
		System.out.println("Starting " + thread_name);
		if (t == null) {
			t = new Thread(this, thread_name);
			t.start();
		}
	}
	
	public int getTotalRunCOunt() {
		return total_run_count;
	}
}

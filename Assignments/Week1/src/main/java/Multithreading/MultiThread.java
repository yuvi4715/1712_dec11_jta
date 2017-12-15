package Multithreading;

public class MultiThread implements Runnable {
	private String name;
	
	public MultiThread(String number) {
		name = number;
	}

	public synchronized void run() {
		int counter = 0;
		for (int i = 0; i < 1000; i++) {
			System.out.printf("Thread %s: %d\n", name,counter++);
		}
		
	}
}

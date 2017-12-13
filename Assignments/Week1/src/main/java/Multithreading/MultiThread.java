package Multithreading;

public class MultiThread extends Thread {

	public synchronized void run() {
		int counter = 0;
		for (int i = 0; i < 1000; i++) {
			System.out.println(counter++);
		}
		
	}
}

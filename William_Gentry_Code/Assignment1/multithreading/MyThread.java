package multithreading;

public class MyThread implements Runnable {


	@Override
	public void run() {
//		this.printIncrement();
		this.printSynchronizedIncrement();
	}
	
	
	public void printSynchronizedIncrement() {
		int counter = 0;
		synchronized(this) {
			while (counter < 1000) {
				System.out.println(Thread.currentThread().getName() + ":\tCount: " + ++counter);
			}
		}
	}
	
	public void printIncrement() {
		int counter = 0;
		while (counter < 1000) {
			System.out.println(Thread.currentThread().getName() + ":\tCount: " + ++counter);
		}
	}
	
	
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread1 = new Thread(myThread, "One");
		Thread thread2 = new Thread(myThread, "Two");
		Thread thread3 = new Thread(myThread, "Three");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	
}

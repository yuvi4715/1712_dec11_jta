package getasew.assignment1.multithreading;
/*
 * Multithreading
Write a method that stores an integer. Each time the method is called, increment the integer by 1. Create three threads that call this method 1000 times each, storing the returned result in their own set. Print out each thread’s set.
Synchronize the method that stores and increments the integer. Execute your threads again.
Review thread-specific methods: sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll()

 */

public class MultiThreadIncrementer implements Runnable {
	private Thread t;
	private String threadName;
	private static int c =0;
	public MultiThreadIncrementer(String name) {
		threadName= name;
	}
	//calle the increment method 1000 times.
	public void run() {
		try {
		for(int i=0;i<1000;i++) {
			System.out.println("i "+i+" thread :"+threadName+" c ="+ increment());
			Thread.sleep(50);
		}
		} catch(InterruptedException e) {
			System.out.println("thread "+ threadName+" is interrupted");
		}
	}
	//method that increment the number
	private synchronized int increment() {
		
		return c++;
	}
	public void start() {
		System.out.println("Starting thread "+ threadName);
		if(t == null){
			t = new Thread(this,threadName);
			t.start();
		}
	
	}
	public static void main(String[] args) {
		
		MultiThreadIncrementer m1 = new MultiThreadIncrementer("Thread-1");
        m1.start();
		MultiThreadIncrementer m2= new MultiThreadIncrementer("Thread-2");
		m2.start();
		MultiThreadIncrementer m3 = new MultiThreadIncrementer("Thread-3");
		m3.start();
		

		 
	}

}

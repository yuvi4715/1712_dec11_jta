package Multithreading;

class Runner implements Runnable {
	public int n;
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Threads.incr();
			n = Threads.n;
		}
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public class Threads {
	public static volatile int n = 0;
	public static synchronized void  incr() {
		n++;
	}
	public static void main(String[] args) {
		// when the method incr() isn't synchronized, n doesn't always
		// get to 3000, but when incr() is synchronized, n
		// gets to 3000 all the tie.
		Runner r1 = new Runner();
		Runner r2 = new Runner();
		Runner r3 = new Runner();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();	
		t2.start();
		t3.start();
		System.out.println("Beginning value of n: " + Threads.n);
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value of thread 1: " + r1.n);
		System.out.println("Value of thread 2: " + r2.n);
		System.out.println("Value of thread 3: " + r3.n);
		System.out.println("Later value of n: " + Threads.n);
	}
}

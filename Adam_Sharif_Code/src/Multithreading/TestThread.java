package Multithreading;

public class TestThread implements Runnable {
	private int number;

	public static void main(String[] args) throws InterruptedException {
		TestThread syn_object = new TestThread();

		Thread t1 = new Thread(syn_object);
		Thread t2 = new Thread((syn_object));
		Thread t3 = new Thread((syn_object));

		t1.start();
		t2.start();
		t3.start();

		// t3.wait();
		// t2.notify();
		// t2.suspend();
		// Adt2.resume();
		// t1.sleep(10000000);

	}

	@Override
	public void run() {

		System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for execution");
		methodstore();
		System.out.println("Thread " + Thread.currentThread().getName() + " has executed method");
	}

	public void methodstore() {
		synchronized (this) {
			for (int i = 0; i < 1000; i++) {
				number++;
				System.out.println("Running " + Thread.currentThread().getName() + " Number: " + number);
				// if ((i % 5) == 0) {
				// System.out.println(Thread.currentThread().getName() + "yielding control...");
				// Thread.yield();
			}
		}
	}
}

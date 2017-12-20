package multithreading;

public class MultiThreading31 {

	public static void main(String[] args) {
		// Review thread-specific methods: 
		// sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll()
		
		Runnable thing = new RunnableObj30();
		Thread worker1 = new Thread(thing);
		worker1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			worker1.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.yield();
		// worker1.suspend(); // deprecated
		// worker1.stop();	// deprecated
		// worker1.resume(); // deprecated
		worker1.interrupt();
		worker1.notify();
		worker1.notifyAll();
	}

}

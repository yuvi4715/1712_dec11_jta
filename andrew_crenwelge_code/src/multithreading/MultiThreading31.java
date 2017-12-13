package multithreading;

public class MultiThreading31 {

	public static void main(String[] args) {
		// Review thread-specific methods: 
		// sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll()
		Runnable thing = new RunnableObj30();
		Thread worker1 = new Thread(thing);
		worker1.start();
		worker1.sleep(1000);
		worker1.wait();
		worker1.yield();
		worker1.suspend();
		worker1.stop();
		worker1.resume();
		worker1.interrupt();
		worker1.notify();
		worker1.notifyAll();
	}

}

package multithreading;

public class MultiThreading30 {
	
	public static void main(String[] args) {
		Runnable thing = new RunnableObj30();
		Thread worker1 = new Thread(thing);
		worker1.start();
		Thread worker2 = new Thread(thing);
		worker2.start();
		Thread worker3 = new Thread(thing);
		worker3.start();
	}
}

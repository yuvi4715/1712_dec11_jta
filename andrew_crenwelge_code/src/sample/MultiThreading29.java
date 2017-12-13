package sample;

public class MultiThreading29 {
	
	public static void main(String[] args) {
		Runnable thing = new RunnableObj29();
		Thread worker1 = new Thread(thing);
		worker1.start();
		Thread worker2 = new Thread(thing);
		worker2.start();
		Thread worker3 = new Thread(thing);
		worker3.start();
	}
}

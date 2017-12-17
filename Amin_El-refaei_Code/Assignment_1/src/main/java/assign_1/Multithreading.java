package assign_1; // this class contains the code for number 29-31

public class Multithreading implements Runnable {

	int x; // created int x without initializing it
	
	public static void main(String[] args) {
		Multithreading multi = new Multithreading(); // new multithreading object called multi
		
		Thread t1 = new Thread(multi); // new thread created on object multi of type multithreading
		t1.start(); // starts the thread
		
		Thread t2 = new Thread(multi);
		t2.start();
		
		Thread t3 = new Thread(multi);
		t3.start();
	}
	
	

	@Override
	public synchronized void run() { // synchronized run class
		
		for (int i = 0; i < 1000; i++) {
			x++; // increment x each time the loop is executed
			System.out.println("This is working");
			System.out.println(x); // print the value of x every time the loop is executed
		}
	}
	
	

}

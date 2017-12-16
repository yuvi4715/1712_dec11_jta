// Antonio Dtosn
// A Class just to test thread
public class TestThread {
//Problem 29 and 30
	public static void main(String[] args) {
		Thread thread1 = new Thread(new StoreInt(), "thread-1");
		Thread thread2 = new Thread(new StoreInt(), "thread-2");
		Thread thread3 = new Thread(new StoreInt(), "thread-3");
		//Start the threads
		thread1.start();
		thread2.start();
		thread3.start();
  }
}

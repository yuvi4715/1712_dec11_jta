//Questions 29, 30, 31
public class Multithreading {

	// Question 29
	public static class IncrementThread extends Thread {
		private Thread t;
		private String threadName;
		private int current;

		IncrementThread(String name) {
			threadName = name;
			current = 0;
			System.out.println("Creating " + threadName);
		}

		public void run() {
			System.out.println("Running " + threadName);
			while (current < 1000) {
				incrementNumber.increment();
				current++;
			}
			System.out.println("Thread " + threadName + " ran " + current + " times");
		}

		public void start() {
			System.out.println("Starting " + threadName);
			if (t == null) {
				t = new Thread(this, threadName);
				t.start();
			}
		}
	}

	public static class incrementNumber {
		public static int number = 0;

		public static synchronized int increment() {
			number++;
			return number;
		}
	}

	public static void main(String[] args) {
		IncrementThread T1 = new IncrementThread("Thread 1");
		T1.start();
		IncrementThread T2 = new IncrementThread("Thread 2");
		T2.start();
		IncrementThread T3 = new IncrementThread("Thread 3");
		T3.start();

		// Question 30
		System.out.println("Synchronizing the increment(); method will help "
				+ "make sure each thread calls the method exactly 1000 times " + "and doesn't go over 1000");

		// Question 31
		System.out.println("sleep() suspends the thread for a certain time, ");
		System.out.println("wait() makes thread wait until another notifies it ");
		System.out.println("yield() temporarily pauses the thread to let others go, ");
		System.out.println("suspend() suspends thread until resume ");
		System.out.println("stop() stops the thread ");
		System.out.println("resume() resumes a suspended thread ");
		System.out.println("interrupt() indicates a thread it shoud stop and do something else ");
		System.out.println("notify() and notifyAll() notifies waiting threads to stop waiting");
	}

}

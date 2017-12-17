package part09_Multithreading;

public class MainThread implements Runnable {
	
	public static void main(String[] args) {
		
		MainThread myThread = new MainThread();
		
		Thread t1 = new Thread(myThread, "One");
		Thread t2 = new Thread(myThread, "Two");
		Thread t3 = new Thread(myThread, "Three");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	// Prints NON-SYNCHRONIZED ThreadCount 
	public void incrementCount() {
		int count = 0;
		while(count < 1000) {
			count++;
			System.out.println(Thread.currentThread().getName() + " Count " + count);
		}
	}
	
	// Prints SYNCHRONIZED ThreadCount
	public void synchronizedIncrementCount() {
		int count = 0;
		synchronized(this) {
			while(count < 1000) {
				count++;
				System.out.println(Thread.currentThread().getName() + " Count " + count);
			}	
		}
	}

	public void run() {
		
		// Implements the Non-Synchronized Threads
//		this.incrementCount();					
		
		// Implements the Synchronized Threads
		this.synchronizedIncrementCount();
		
	}
	
	
	// Thread.sleep(x)		-- suspends the system for x number of milliseconds
	// Thread.wait()		-- forces the thread to wait until it is 'woken up' with the .notify() method
	// Thread.yield()		-- causes the current thread to pause, and let the other threads execute
	// Thread.suspend()		-- forces the thread to enter a 'Suspended' state, can be interrupted with the .resume() method
	// Thread.stop()		-- stop a thread completely
	// Thread.resume()		-- resumes a thread in the 'Suspended' state
	// Thread.interrupt()	-- safe-way to cancel a thread, but the program must know to pay attention to interrupts
	// Thread.notify()		-- 'wakes up' a thread
	// Thread.notifyAll()	-- 'wakes up' ALL threads
	
}

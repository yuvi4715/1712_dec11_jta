package multithreading;

public class Multithreading extends Thread {	//#runnable for multithreading
	Thread t;
	String tid;
	int count;
	
	public Multithreading (String tid) {
		this.tid = tid;
		count = 0;
	}
	
	public void run() {
		for (int i=0; i<1000; i++) {
			//increment();
			incrementsync();
			//System.out.println(tid + " " + count);
		}
		System.out.println(tid + ": " + count);
	}
	
	public int increment() {	//#29
		count++;	//post
		return count;
	}
	
	public synchronized int incrementsync() {	//#30 
		count++;	//post
		return count;
	}
	
	/*	//#31
		sleep(long millis)
			- Causes the currently executing thread to sleep for the specified number of milliseconds
		wait()
			-current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object
		yield()
			-A hint to the scheduler that the current thread is willing to yield its current use of a processor.
		suspend()
			- deprecated, suspends thread
		stop()
			- deprecated, stops thread
		resume()
			- deprecated, resumes suspended state
		interrupt()
			- interrupts thread
		notify()
			- Wakes up a single thread that is waiting on this object's monitor. I
		notifyAll()
			- Wakes up all threads that are waiting on this object's monitor
	*/
}

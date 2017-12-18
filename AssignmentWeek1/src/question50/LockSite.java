package question50;

public class LockSite implements Runnable {

	Object lock1 = new Object();
	Object lock2 = new Object();
	LockThread[] threads = new LockThread[2];
	
	Object getObject(Object obj) {
		Object obj1;
		if(obj == lock1) {
			obj1 = lock1;
		}
		else {
			obj1 = lock2;
		}
		return obj1;
	}
	void lockVariable(LockThread lockThread) {
		synchronized(getObject(lockThread.left)) {
			try {
				System.out.printf("Locking %s's left object\n", lockThread.getName());
				LockThread.sleep(50);
				synchronized(getObject(lockThread.right)) {
					System.out.printf("Locking %s's right object\n", lockThread.getName());
					LockThread.sleep(50);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("The job has been completed.");
	}
	void createDeadlock() {
		if(LockThread.currentThread() == threads[0])
			lockVariable(threads[0]);
		else {
			lockVariable(threads[1]);
		}
	}
	void createLivelock() {
		
	}
	
	void setThreads() {
		synchronized(threads) {
			if(threads[0] == null) {
				threads[0] = (LockThread) LockThread.currentThread();
				try {
					threads.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				threads[1] = (LockThread) LockThread.currentThread();
				threads.notify();
			}
		}
		
	}
	
	@Override
	public void run() {
		setThreads();
		if(threads[0].getName() == "Thread2" || threads[1].getName() == "Thread2")
			createDeadlock();
		else 
			createLivelock();
	}
}

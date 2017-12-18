package question50;

public class LockMain {

	LockThread thread1;
	LockThread thread2;
	LockThread thread3;
	LockSite lockSite = new LockSite();
	public static void main(String[] args) {

		LockMain lockmain = new LockMain();
		lockmain.setupDeadlock();
		
	}
	
	void setupDeadlock() {
		thread1 = new LockThread(lockSite.lock1, lockSite.lock2, lockSite);
		thread2 = new LockThread(lockSite.lock2, lockSite.lock1, lockSite);
		thread1.setName("Thread1");
		thread2.setName("Thread2");
		thread1.start();
		thread2.start();
	}
	void setupLivelock() {
		thread1 = new LockThread(lockSite.lock1, lockSite.lock2, lockSite);
		thread3 = new LockThread(lockSite.lock1, lockSite.lock2, lockSite);
		thread1.setName("Thread1");
		thread3.setName("Thread3");
		thread1.start();
		thread3.start();
	}

}

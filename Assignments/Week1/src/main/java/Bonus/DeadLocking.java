package Bonus;

public class DeadLocking {

	public static  Object lock1 = new Object();
	public static  Object lock2 = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread1 = new Thread(new ThreadLock1(lock1, lock2));
		Thread thread2 = new Thread(new ThreadLock1(lock1,lock2));
		
		try {
			for (int i = 0; i < 5; i++) {
				thread1.start();
				thread2.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deadlocked, exiting...");
			System.exit(0);
		}



	}
}



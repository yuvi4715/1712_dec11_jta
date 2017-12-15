package Bonus;

public class ThreadLock1 implements Runnable {
	private Object locks1;
	private Object locks2;

	public ThreadLock1(Object lock, Object lock2) {
		locks1 = lock;
		locks2 = lock2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (locks1) {
			try {
				System.out.println("Oh Thread 1 has the app!");

				Thread.sleep(100);
			} catch (IllegalThreadStateException e) {
				System.out.println("It locked out!");
				System.exit(-1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		synchronized (locks2) {
			try {
				System.out.println("Oh Thread 1 has the app!");

				Thread.sleep(200);
			} catch (IllegalThreadStateException e) {
				System.out.println("It locked out!");
				System.exit(-1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

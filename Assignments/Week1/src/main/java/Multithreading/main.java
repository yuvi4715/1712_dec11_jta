package Multithreading;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread thread = new Thread(new MultiThread("One"));
		Thread thread2 = new Thread(new MultiThread("Two"));
		Thread thread3 = new Thread(new MultiThread("Three"));
		
		new main().letsRun(thread);
		new main().letsRun(thread2);
		new main().letsRun(thread3);


	}
	
	private void letsRun(Thread thread) throws InterruptedException {
		synchronized (thread) {
			thread.start();
			thread.wait();
		}
	
	}

}

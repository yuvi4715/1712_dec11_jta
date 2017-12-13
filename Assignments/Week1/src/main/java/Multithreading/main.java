package Multithreading;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
		MultiThread mt1 = new MultiThread();
		
		Thread threadJob1 = new Thread(mt1);
		Thread threadJob2 = new Thread(mt1);
		Thread threadJob3 = new Thread(mt1);
		
		new main().letsRun(threadJob1);
		new main().letsRun(threadJob2);
		new main().letsRun(threadJob3);
	}
	
	private void letsRun(Thread thread) throws InterruptedException {
		synchronized (thread) {
			thread.start();
			thread.wait();
		}
	}

}

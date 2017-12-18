package question29_30_31;

public class MultithreadingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
			Many threads can run on the same runnable.
			Every thread that does so has access to the field of the runnable.
		*/
		Multithreading threadJob = new Multithreading(); 
		
		Thread thread1 = new Thread(threadJob);
		Thread thread2 = new Thread(threadJob);
		Thread thread3 = new Thread(threadJob);
		
		thread1.start();
		thread2.start();
		thread3.start();

	}	
}

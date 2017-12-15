package com.assignment1.problem29thru31;

public class MainClass {
	

	public static void main(String[] args) {
		String name1 = "Alpha";
		String name2 = "Beta";
		String name3 = "Delta";
		
		MyThread t1 = new MyThread(name1);
		t1.start();
		MyThread t2 = new MyThread(name2);
		t2.start();
		MyThread t3 = new MyThread(name3);
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		t1.printInt();
		t2.printInt();
		t3.printInt();
	}

}

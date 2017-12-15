package com.assignment1.problem29thru31;

public class MyThread extends Thread{
	String name;
	Thread t;
	static int i = 0;
	
	public MyThread(String name) {
		super();
		this.name = name;
	}

	public void run()
	{
		//int x = 0;
		System.out.println("Starting thread " + name);
		for(int j = 0; j < 1000; j++)
		{
			increment();
			//System.out.println(name + i);
			//x++;
		}
		System.out.println("Thread " + name + " exiting." + i);
		//System.out.println("Exe:" + x);
	}
	
	public static synchronized void increment()
	{
		i++;
	}
	
	public void printInt()
	{
		System.out.println(i);
	}
}

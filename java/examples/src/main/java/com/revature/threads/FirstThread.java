package com.revature.threads;

public class FirstThread {

	public static void main(String[] args) {
		Thread t1 = new Thread();
		t1.start();
		System.out.println(t1.isAlive());
		System.out.println(t1.isDaemon());
		System.out.println(t1.getName());
	}

}

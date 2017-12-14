package com.revature.as1.multithreading;

public class ThreadDriver {
	
	public static void main(String[] args) {
		ThreadedIncrementer ti1 = new ThreadedIncrementer();
		ti1.start();
		
		ThreadedIncrementer ti2 = new ThreadedIncrementer();
		ti2.start();
		
		ThreadedIncrementer ti3 = new ThreadedIncrementer();
		ti3.start();
	}

}

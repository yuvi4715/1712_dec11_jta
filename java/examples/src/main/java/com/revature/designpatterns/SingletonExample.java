package com.revature.designpatterns;

//Singleton is a creational design pattern
public class SingletonExample {
	private static SingletonExample instance = null;
	
	//make the constructor private
	private SingletonExample() {
	}
	
	//Use public method to return an instance of current object7
	public static SingletonExample getInstance() {
		if (instance == null) {
			instance = new SingletonExample();
		}
		return instance;
	}
}

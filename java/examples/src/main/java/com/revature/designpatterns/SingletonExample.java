package com.revature.designpatterns;

public class SingletonExample {
	private static SingletonExample instance = null;
	private SingletonExample() {
	}
	public static SingletonExample getInstance() {
		if (instance == null) {
			instance = new SingletonExample();
		}
		return instance;
	}
}

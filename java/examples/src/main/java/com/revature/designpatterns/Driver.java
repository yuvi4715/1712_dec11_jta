package com.revature.designpatterns;

public class Driver {

	public static void main(String[] args) {
		SingletonExample.getInstance();
		System.out.println(SingletonExample.getInstance());
		System.out.println(SingletonExample.getInstance());
		//multiple references but only one object is created
	}

}

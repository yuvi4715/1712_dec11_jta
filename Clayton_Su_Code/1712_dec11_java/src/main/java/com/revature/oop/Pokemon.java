package com.revature.oop;

public interface Pokemon {
	public void attack();
	public void run();
	public void wipeOut();
	public void switchOut();
	public void obey();
	public void evolve();
	
	static void speak() //java 1.8 only, default works too
	{
		System.out.println("poke - speaks");
	}
	
}

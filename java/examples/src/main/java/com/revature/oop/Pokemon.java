package com.revature.oop;

public interface Pokemon {

	//methods are implicitly abstract in nature
	public void attack();
	public void run();
	public void wipeOut();
	public void switchOut();
	public void obey();
	public void evolve();
	
	default void speak() {
		System.out.println("poke - speaks");
	}
	
}

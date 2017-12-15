package com.revature.oop;

public class Main extends ElectroBuzz{

	public static Pokemon Electrobuzz = null;
	
	public static void main(String[] args) 
	{
		//Pokemon ElectroBuzz = new Pokemon(); cannot instantiate interface
		Electrobuzz = new Pikachu();
		//ElectroBuzz.attack();
	}
	
	@Override
	public void swim()
	{
		System.out.println("swim");
	}

}

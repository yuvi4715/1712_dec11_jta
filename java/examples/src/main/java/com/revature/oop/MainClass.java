package com.revature.oop;

public class MainClass extends ElectroBuzz {

	//public static Pokemon ElectroBuzz = null;
	
	public static void main(String[] args) {

		Pokemon ElectroBuzz = new Pikachu(); 
		ElectroBuzz.attack();
		ElectroBuzz.evolve();
		ElectroBuzz.obey();
		
		new MainClass().swim();
	}

	@Override
	public void swim() {
		System.out.println("ElectroBuzz - swim");
	}
	
	
}

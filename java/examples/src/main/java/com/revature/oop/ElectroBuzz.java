package com.revature.oop;

public abstract class ElectroBuzz implements Pokemon {

	public ElectroBuzz() {
	}
	
	@Override
	public void attack() {
		System.out.println("ElectroBuzz - attack");
	}

	@Override
	public void run() {
		System.out.println("ElectroBuzz - run");
	}
	@Override
	public void wipeOut() {
		System.out.println("ElectroBuzz - wipeOut");
	}
	@Override
	public void switchOut() {
		System.out.println("ElectroBuzz - switch out");
	}

	@Override
	public void obey() {
		System.out.println("ElectroBuzz - obey");
	}

	@Override
	public void evolve() {
		System.out.println("ElectroBuzz - evolve");
	}
	
	public abstract void swim();	

}

package com.revature.oop;

public abstract class ElectroBuzz extends Pikachu{
	
	public abstract void swim();

	@Override
	public void attack() {
		System.out.println("ElectroBuzz attack");
	}

	@Override
	public void run() {
		System.out.println("ElectroBuzz Run");
	}

	@Override
	public void wipeOut() {
		// TODO Auto-generated method stub
		super.wipeOut();
	}

	@Override
	public void switchOut() {
		// TODO Auto-generated method stub
		super.switchOut();
	}

	@Override
	public void obey() {
		// TODO Auto-generated method stub
		super.obey();
	}

	@Override
	public void evolve() {
		// TODO Auto-generated method stub
		super.evolve();
	}
}

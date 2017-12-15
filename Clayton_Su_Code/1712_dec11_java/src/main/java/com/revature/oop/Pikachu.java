package com.revature.oop;

public class Pikachu implements Pokemon {

	@Override
	public void attack() {
		System.out.println("Pikachu can attack");
	}

	@Override
	public void run() {
		System.out.println("Pikachu can run");
	}

	@Override
	public void wipeOut() {
		System.out.println("Pikachu gets wiped out");
	}

	@Override
	public void switchOut() {
		System.out.println("Pikachu switch out");
	}

	@Override
	public void obey() {
		System.out.println("Pikachu sometimes obeys ");
	}

	@Override
	public void evolve() {
		System.out.println("Pikachu evolves");
	}

}

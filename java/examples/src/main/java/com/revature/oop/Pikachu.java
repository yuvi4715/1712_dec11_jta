package com.revature.oop;

public class Pikachu implements Pokemon {
	
	@Override
	public void attack() {
		System.out.println("Pikachu can definitely attack");
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
		System.out.println("Pikachu can switchOut");
	}
	@Override
	public void obey() {
		System.out.println("sometimes Pikachu obeys");
	}

	@Override
	public void evolve() {
		System.out.println("Pikachu is evolving");
	}


}

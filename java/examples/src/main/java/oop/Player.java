package oop;

public class Player {

	//if you don't have a constructor JVM will create the default constructor
	
	public Player() {
		//System.out.println("Player - Constructor");
	}
	 void run() {
		System.out.println("player can actual run");
	}
	
	public void jump() {
		System.out.println("players can actually jump");
	}
	
	public void fetch() {
		System.out.println("players can try to fetch");
	}
	
	//overloading - change the data type, change number of parameters, order of parameters
	public void jump(int x) {
		System.out.println("number of players good at jumping " + x);
	}
	
	public void jump(int x, int y) {
		System.out.println("number of players good at jumping " + (x+y));
	}
	
	public void jump(int x, int y, int z) {
		System.out.println("number of players good at jumping " + (x+y+z));
	}
	
	public void jump(int x, float f) {
		System.out.println("number of players good at jumping " + x + f);
	}
	
	public void jump(float f, int x) {
		System.out.println("number of players good at jumping " + f + x);
	}
	
}

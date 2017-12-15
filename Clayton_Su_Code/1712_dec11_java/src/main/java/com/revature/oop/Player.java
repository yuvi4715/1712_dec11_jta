package com.revature.oop;

public class Player {
	public Player() {
		System.out.println("Player Constructor");
		
	}
	protected void run()
	{
		System.out.println("player can actual run");
	}
	
	public void jump()
	{
		System.out.println("players can jump");
	}
	
	public void fetch()
	{
		System.out.println("players can try to fetch");
	}
	
	public void jump(int x, int y)
	{
		System.out.println("Number of players good at jumping" + (x +y));
	}
	
	
}


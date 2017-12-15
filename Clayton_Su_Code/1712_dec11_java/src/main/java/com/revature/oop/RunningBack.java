package com.revature.oop;

public class RunningBack extends Player{
	public void stiffArm()
	{
		System.out.println("RB's are good");
	}
	
	@Override
	public void run()
	{
		System.out.println("RB's are better at running");
	}
	
	public static void main(String[] args) {
		RunningBack rb1 = new RunningBack();
		rb1.fetch();
		rb1.run();
		rb1.stiffArm();
		rb1.jump();
		
		Player p1 = new Player();
		Player p2 = new RunningBack();
		//RunningBack p3 = new Player(); does not work,
			//right to left check. Not all players are running back
			//running back is a Player
		
		//p1.stiffArm(); does not work
		
		p2.fetch();
		p2.run(); //it will use RunningBack's run instead of Player's run
		//p2.stiffArm() no work 
		p2.jump();
	}
}

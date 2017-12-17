package oop;

public class RunningBack extends Player{

	public void stiffArm() {
		System.out.println("RB's are especially good with stiff Arm");
	}
	
	@Override
	public void run() {
		System.out.println("RB's better be good with running");
	}
	
	public static void main(String[] args) {
		RunningBack rb1 = new RunningBack();
		rb1.fetch();
		rb1.jump();
		rb1.run();
		rb1.stiffArm();
		Player p1 = new Player();
		p1.fetch();
		p1.jump();
		p1.run();
		//p1.stiffArm();
		
		Player p2 = new RunningBack();
		p2.fetch();
		p2.jump();
		p2.run();
		//p2.stiffArm();
		//RunningBack p3 = new Player(); 
	}
}

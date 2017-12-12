package oop;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestPlayer {

	//Annotations - is an interface which ensures a task is performed by informing JVM
	//syntax for annotations - @keyword
	
	Player p1 = new Player();
	@Before
	public void setUp() throws Exception {
		System.out.println("setup - before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down - after");
		System.out.println("===========");
	}

	@Ignore
	@Test
	public void testRun() {
		p1.run();
	}

	//@Ignore
	@Test
	public void testJump() {
		p1.jump();
		p1.jump(10);
		p1.jump(10, 20);
		p1.jump(10, 10, 5);
		p1.jump(10, 222222222);
		p1.jump(333333333, 20);
	}

	@Ignore
	@Test
	public void testFetch() {
		p1.fetch();
	}

}

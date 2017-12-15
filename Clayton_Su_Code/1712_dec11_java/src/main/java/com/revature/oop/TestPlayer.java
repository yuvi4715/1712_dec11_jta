package com.revature.oop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestPlayer {

	Player p1 = new Player();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down -- after");
		System.out.println("=================");
	}

	
	@Test
	public void testRun() {
		//fail("Not yet implemented");
		p1.run();
	}
	
	@Test
	public void testJump() {
		//fail("Not yet implemented");
		p1.jump();
		p1.jump(10, 20);
	}

	@Test
	public void testFetch() {
		//fail("Not yet implemented");
		p1.fetch();
	}
		

}

package com.revature.extras;

/*
 * An interface, that only has one, unimplemented, method signature, is called
 * a 'functional interface'. These type of interfaces cater to lambda expressions.
 */

@FunctionalInterface
public interface PerformMath {

	public int doSomething(int a, int b);
	
/*	default void doSomethingElse() {
		System.out.println("do something else");
	}*/
}

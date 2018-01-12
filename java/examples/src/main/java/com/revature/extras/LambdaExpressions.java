package com.revature.extras;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {

	public static void main(String[] args) {

		PerformMath addition = (a, b) -> (a + b);
		PerformMath subtraction = (a, b) -> (a - b);

		System.out.println(addition.doSomething(10, 20));
		System.out.println(addition.doSomething(10, 20));
		System.out.println(subtraction.doSomething(30, 20));
		System.out.println(subtraction.doSomething(40, 20));

		// method references
		// refer to instance method or static method
		// forEach

		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		for (Integer l : l1) {
			System.out.println(l);
		}

		l1.forEach(System.out::println);

	}

/*
 * A lambda expression is an expression that makes use of '->' to define that
 * reference at run time. In this case, we provided implementation to the
 * signature in the functional interface, 'PerformMath'
 * 
 * Lambda syntax goes as follows:
 * 
 * (parameters to be used) -> (expression to be executed) Java will determine
 * how to use them, and what gets returned for you. If you want, you can let
 * Java also determine what datatypes should be used.
 * 
 * Note: if you only have one parameter, parenthesis on the left are optional:
 * e.g. a -> (a*a) And if you want to use NO parameters, parenthesis' are
 * mandatory. e.g. () -> syso("Stuff");
 
 * Method References -A method reference provides a way to call a specific
 * method -on each element of a collection. A few syntaxes include:
 * (class::method) (class::new) <- in the case we want to provide a new instance
 * each time
 * 
 */
	static void myMethod1() {

	}

}

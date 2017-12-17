package com.revature.exceptions;

/*
 * Nathan Poole
 * Question Thirteen
 * Duck an exception at least once
 */

public class QuestionThirteen {

	public static void main(String[] args) throws QuestionTen{
		duckAndCover();
	}

	private static void duckAndCover() throws QuestionTen{
		throw new QuestionTen();
	}
}

package com.revature.question37;

// Write a program called GradesStatistics, which reads in n grades (of int between 0 and 100, inclusive) and displays the 
// average, minimum, maximum, and standard deviation. Your program shall check for valid input. 
//You should keep the grades in an int[] and use a method for each of the computations.

public class GradesStatistics {
	
	public static void checkInput(int[] numbers) {
		// Check for valid inputs between 0 and 100
		for (int e : numbers) {
			if (e < 0 || e > 100) {
				System.out.println(e + " is not between 0 and 100");
				System.exit(0);
			}
		}
		average(numbers);
	}
	
	public static void average(int[] numbers) {
		// Sum each element and divide by the amount for average
		int n = numbers.length;
		int avg = 0;
		for (int e : numbers) {
			avg += e;
		}
		System.out.println("The average is " + (avg/n));
		minimum(numbers);
	}
	
	public static void minimum(int[] numbers) {
		// Store the first number temporarily and compare to each to find max
		int min = numbers[0];
		for (int e : numbers) {
			if (e < min) {
				min = e;
			}
		}
		
		System.out.println("The minimum is " + min);
		maximum(numbers);
	}
	
	public static void maximum(int[] numbers) {
		// Store the first number temporarily and compare to each to find max
		int max = numbers[0];
		for (int e : numbers) {
			if (e > max) {
				max = e;
			}
		}
		
		System.out.println("The maximum is " + max);
		standardDeviation(numbers);
	}
	
	public static void standardDeviation(int[] numbers) {
		// Work out the mean 
		int n = numbers.length;
		int avg = 0;
		double sumOfSqDiff = 0;
		for (int e : numbers) {
			avg += e;
		}
		avg /= n;
		// Then for each number: subtract the Mean and square the result
		for (int num : numbers) {
			sumOfSqDiff += Math.pow((num - avg), 2);
		}
		// Then work out the mean of those squared differences and square root
		System.out.println("The standard deviation is " + Math.sqrt(sumOfSqDiff/n));
	}
	
	public static void main(String[] args) {
		// Grab all of the arguments passed and store in an array
		int[] numbers = new int[args.length];
		for (int i = 0; i < args.length; i++)
		{	
		    try 
		    {
		        numbers[i] = Integer.parseInt(args[i]);
		    } 
		    
		    // Check for non numbered arguments
		    catch (NumberFormatException nfe)   
		    {
		        System.out.println("Not a valid number");
		        System.exit(0);
		    }
		}		
		System.out.println("The numbers are: ");
		for (int e : numbers) {
			System.out.print(e + " ");
		}
		System.out.println("");
		checkInput(numbers);
	}
}

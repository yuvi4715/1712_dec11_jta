package com.revature.week1.EasyCodingExercises;

import java.util.Scanner;

public class GradeStatistics {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// How many numbers you want to enter in an array for computations
		System.out.println("How many numbers do you want to enter?");
		int num = input.nextInt();

		int grades[] = new int[num];

		System.out.println("Enter the " + num + " numbers now.");

		for (int i = 0; i < grades.length; i++) {
			grades[i] = input.nextInt();
		}

		GradeStatistics gs = new GradeStatistics();
		double average = gs.average(grades);
		System.out.println("The average is " + average);

		int min = gs.minmum(grades);
		System.out.println("The minimum is " + min);

		int max = gs.maximum(grades);
		System.out.println("The maximum is " + max);

		double sd = gs.standardDeviation(grades);
		System.out.println("The standard deviation is " + sd);

	}

	// Calculates the average from the array
	public double average(int[] grades) {
		double average = 0;
		int sum = 0;
		int count = 0;

		for (int i = 0; i < grades.length; i++) {
			sum = sum + grades[i];
			count++;
		}
		average = sum / count;
		return average;

	}

	// Calculates the min from the array
	public int minmum(int[] grades) {

		int min = grades[0];
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;

	}

	// Calculates the max for an array
	public int maximum(int[] grades) {

		int max = grades[0];
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;

	}

	// Calculates the standard deviation from the array
	public double standardDeviation(int[] grades) {

		double sum = 0.0, standardDeviation = 0.0;

		for (double num : grades) {
			sum += num;
		}

		double mean = sum / 10;

		for (double num : grades) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return Math.sqrt(standardDeviation / 10);
	}

}

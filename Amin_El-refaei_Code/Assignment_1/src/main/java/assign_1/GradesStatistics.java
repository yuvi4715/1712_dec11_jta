package assign_1; // This class containd the code for number 37

import java.util.Scanner;

public class GradesStatistics {
	
	private static double average = 0; // created a private static double variable called average

	public static void main(String[] args) {
		Scanner scores = new Scanner(System.in); // created a scanner to take input from the user

		System.out.println("Enter the size of the array of grades");
		int n;
		n = scores.nextInt(); // int n is assigned the next int that is entered into the scanner

		int[] grades = new int[n]; // created a new array of int's called grades of size n

		for (int i = 0; i < grades.length; i++) { // for loop which takes input from the user to enter the grades
			System.out.println("Enter the grades: " + i);
			grades[i] = scores.nextInt();
		}

		System.out.println("The grades are: ");
		for (int i = 0; i < grades.length; i++) { // loops through grades array and prints each element
			
//			if (n < 0 ) {
//				System.out.println("This is not a valid score. Please try again");
//			} else if (n > 100 ) {
//				System.out.println("This is not a valid score. Please try again");
//			}
			
			System.out.print(grades[i] + "\n");
		}

		findMax(grades); // statically calling findMax() method and passing the grades array as the parameter

		findMin(grades); // statically calling findMin() method and passing the grades array as the parameter

		findAverage(grades); // statically calling findAverage() method and passing the grades array as the parameter
		
		findStandardDev(grades); // statically calling findStandardDev() method and passing the grades array as the parameter

		scores.close();
	}

	public static void findMax(int[] grades) { // method to find the maximum grade
		int maxValue = grades[0]; // setting int maxValue to the first object in the grades array
		for (int i = 0; i < grades.length; i++) { // for loop to iterate through the objects in the grades array
			if (grades[i] > maxValue) { // if the current object in the grades array is larger than maxValue
				maxValue = grades[i]; // that object becomes the new maxValue
			}

		}
		System.out.println("The maximum grade is: " + maxValue);
	}

	public static void findMin(int[] grades) { // method to find the minimum grade
		int minValue = grades[0]; // setting int minValue to the first object in the grades array
		for (int i = 0; i < grades.length; i++) { // for loop to iterate through the objects in the grades array
			if (grades[i] < minValue) { // if the current object in the grades array is smaller than minValue
				minValue = grades[i]; // that object becomes the new minValue
			}

		}
		System.out.println("The minimum grade is: " + minValue);
	}

	public static void findAverage(int[] grades) { // method to find the average grade
		int sum = 0; // created int sum and initialized it to 0
		for (int i = 0; i < grades.length; i++) { // for loop to iterate through the objects in the grades array
			sum += grades[i]; // sum equals sum + the current object in the grades array
			average = sum / grades.length; // average equal sum divided by the length of the grades array
		}
		System.out.println("The average grade is: " + average);
	}
	
	public static void findStandardDev(int[] grades) { // method to find the standard deviation
		double standardDeviation = 0; // created a double standardDeviation and initialized it to 0
		for (int i = 0; i < grades.length; i++) { // for loop to iterate through the objects in the grades array
			{
				standardDeviation += ((grades[i] - average) * (grades[i] - average)) / (grades.length - 1);
			} // the calculations to get the standardDeviation
		}
		double standardDev = Math.sqrt(standardDeviation);
		System.out.println("Standard deviation: " + standardDev);
	}
}

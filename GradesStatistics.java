package com.revature.day1;

import java.util.Scanner;

public class GradesStatistics {


		public void getGrades()  //gets the number of grades to be entered
		{
		Scanner reader = new Scanner(System.in);
		System.out.println("enter number of grades between 0 and 100: ");
		int numgrades = reader.nextInt();
		
		
		
		if(numgrades < 0 || numgrades > 100) {
			System.out.println("not within range; try again");
			getGrades();
		} else {
			enterGrades(numgrades);
			reader.close();
		}
		}
		
	
		
		public void enterGrades(int arraylimit)  //enter each grade element
		{
		int x;
		int[] gradesArray = new int[arraylimit];
		
		for (x=0; x < arraylimit; x++)
		{
		Scanner reader = new Scanner(System.in);
		System.out.println("enter grade: ");
		gradesArray[x] = reader.nextInt();  //fills the array
		
		
		
		//computeEverything(gradesArray);
		//reader.close();
		}
		computeEverything(gradesArray);
		}

		
			
			
		
		
		public double computeEverything(int[] array)
		{
			double avg = 0;
			double sum = 0;
			int x;
			
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			
			double powerSum1 = 0;
			double powerSum2 = 0;
			double stdev = 0;
			
			for (x=0; x < array.length; x++) 
			{
			
			System.out.println(array[x]);
			sum = sum + array[x];
			
			if (array[x] < min) {
				min = array[x];
			} else if (array[x] > max) {
				max = array[x];
			}
			
			/*powerSum1 += array[x];
			powerSum2 += Math.pow(array[x], 2);
			//stdev = Math.sqrt(x*powerSum2 - Math.pow(powerSum1, 2))/x;
			stdev = Math.sqrt(x*powerSum2 - Math.pow(powerSum1, 2))/x;*/
			}
			
			
			avg = sum / array.length;
			
			//calculate standard deviation
			int y;
			double sum2 = 0;
			double devMean = 0;
			
			for (y=0; y < array.length; y++) 
			{
			sum2 += Math.sqrt(array[y] - avg);	
			}
			devMean = sum2 / array.length;
			stdev = Math.sqrt(devMean);
			
			System.out.println("the average is " + avg);
			
			System.out.println("the min is " + min);
		
			System.out.println("the max is " + max);
			
			System.out.println("the standard deviation is " + stdev);
			return stdev;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GradesStatistics example = new GradesStatistics();
		example.getGrades();
		
		
	}

}

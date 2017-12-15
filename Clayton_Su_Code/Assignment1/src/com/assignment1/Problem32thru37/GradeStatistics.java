package com.assignment1.Problem32thru37;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeStatistics {

	public static ArrayList<Integer> readGrades()
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println("Enter integers (Format:1 2 3 4) for grades, enter non-integer to stop.");
		
		while(sc.hasNextInt())
		{
			list.add(sc.nextInt());
		}
		System.out.println(list);
		sc.close();
		return list;
	}
	
	public static double findAvg(ArrayList<Integer> a)
	{
		double sum = 0;
		for(int i = 0; i < a.size(); i++)
		{
			sum = sum + a.get(i);
		}
		System.out.println("Avg: " + (sum / a.size()));
		
		return sum / a.size();
	}
	
	public static double findAvgForSD(ArrayList<Double> a)
	{
		double sum = 0;
		for(int i = 0; i < a.size(); i++)
		{
			sum = sum + a.get(i);
		}
		System.out.println("Avg: " + (sum / a.size()));
		
		return sum / a.size();
	}
	
	
	public static void findMin(ArrayList<Integer> a)
	{
		int min = 100;
		for(int i = 0; i < a.size(); i++)
		{
			if(a.get(i) < min)
			{
				min = a.get(i);
			}
		}
		System.out.println("Min: " +min);
	}
	
	
	
	public static void findMax(ArrayList<Integer> a)
	{
		int max = 0;
		for(int i = 0; i < a.size(); i++)
		{
			if(a.get(i) > max)
			{
				max = a.get(i);
			}
		}
		System.out.println("Max: " +max);
	}
	
	public static void findDevia(ArrayList<Integer> a)
	{
		double mean = findAvg(a);
		double temp = 0.0;
		ArrayList<Double> d = new ArrayList<Double>();
		for(int i = 0; i < a.size(); i++)
		{
			temp = a.get(i) - mean;
			d.add(temp*temp);
		}
		temp = findAvgForSD(d);
		double sd = Math.sqrt(temp);
		System.out.println(sd);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = readGrades();
		findAvg(a);
		findMin(a);
		findMax(a);
		findDevia(a);
		System.out.println("Done.");
		
		
	}
}

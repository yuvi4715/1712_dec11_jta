package com.revature.week1.FileIO;

public class TestCOde {
	public static void main(String[] args) {
		int[] mode = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		int j = 0;
		int i = 0;
		while (j < 16) {
				if (i == 0) {
					System.out.println("0");
					i++;
					j++;
				} else if (i == 1) {
					System.out.println("1");
					i++;
					j++;
				} else if (i == 2) {
					System.out.println("2");
					i++;
					j++;
				} else if (i == 3) {
					System.out.println("3");
					i++;
					j++;
				}else {
					i = 0;
				}
				
		}
	}
}

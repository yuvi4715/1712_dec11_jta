package bonusExercises;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		printPascalTriangle(20);
	}
	
	public static void printPascalTriangle(int i) {
		/*
		 * 
		 */
		// will print Pascal's Triangle to row i
		// need an ArrayList to hold the ArrayList
		List<List<Integer>> rows = new ArrayList<>();
		for (int a=0;a<i;a++) { // a is the row we are one
			List<Integer> list = new ArrayList<>();
			if (a == 0) {
				list.add(1);
				rows.add(list);
			}
			else if (a == 1) {
				list.add(1);
				list.add(1);
				rows.add(list);
			}
			else {
				list.add(1); // the first 1 on the line
				for (int x=1;x<=a-1;x++) { // x is the position in the row (i.e. column #)
					int above1 = rows.get(a-1).get(x-1);
					int above2 = rows.get(a-1).get(x);
					list.add(above1 + above2); // add the two numbers above
				}
				list.add(1); // the last 1 on the line
				rows.add(list); // add the list as a row
			}
		}
		for (List<Integer> l : rows) {
			System.out.println(l);
		}
	}

}

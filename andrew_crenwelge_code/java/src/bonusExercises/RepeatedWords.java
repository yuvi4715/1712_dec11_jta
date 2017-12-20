package bonusExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RepeatedWords {
	/*
	 * Write a program that counts repeated words in a file.
	 */

	public static void main(String[] args) {
		parseFile();
	}
	
	private static void parseFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/resources/repeated.txt"));
			Map<String, Integer> strMap = new HashMap<String,Integer>();
			String l;
			StringBuilder sb = new StringBuilder();
			while((l = br.readLine()) != null) {
				sb.append(l);
				String[] arr = l.split(" ");
				for (String a : arr) {
					if (strMap.containsKey(a)) {
						strMap.put(a, strMap.get(a)+1);
					}
					else
						strMap.put(a, 1);
				}
			}
			System.out.println("Word \t\t\t # of repeats");
			System.out.println("________________________________");
			for (String b : strMap.keySet()) {
				System.out.println(b + "\t\t\t" + strMap.get(b));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

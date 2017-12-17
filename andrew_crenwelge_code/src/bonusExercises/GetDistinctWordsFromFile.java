package bonusExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GetDistinctWordsFromFile {

	public static void main(String[] args) {
		Set<String> words = getDistinctWords();
		System.out.println(words);
	}
	
	private static Set<String> getDistinctWords() {
		// we need a set to store the unique words
		Set<String> uniqueWords = new TreeSet<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/resources/repeated.txt"));
			// we need a map to store each word and the # of times it appears
			Map<String, Integer> wordMap = new HashMap<>();
			String l;
			while((l = br.readLine()) != null) {
				String[] arr = l.split(" ");
				for (String s : arr) {
					if(wordMap.containsKey(s)) {
						wordMap.put(s, wordMap.get(s)+1);
					}
					else {
						wordMap.put(s, 1);
					}
				}
			}
			for (String s : wordMap.keySet()) {
				if (wordMap.get(s) == 1)
					uniqueWords.add(s);
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
		return uniqueWords;
	}
}
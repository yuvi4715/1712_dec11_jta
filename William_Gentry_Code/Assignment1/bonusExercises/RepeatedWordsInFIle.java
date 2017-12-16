package bonusExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class RepeatedWordsInFIle {

	/*
	 * 
	 * This program works properly, still not convinced if I want to 
	 * turn this program in yet
	 * 
	 * 
	 * EDIT: added multiple delimiters to split() method, believe it is now accurate
	 * 
	 */
	
	private static final String FILENAME = "src/bonusExercises/LoremIpsum.txt";
	
	
	public static void wordsRepeatedInAFileWithOccurrences(String fileName) {
		int wordCounter = 0;
		
		BufferedReader br = null;
		try {													//Count number of lines in File
			br = new BufferedReader(new FileReader(fileName));
			String s;
			while ((s = br.readLine()) != null) {
				String[] words = s.split(" | ,");
				for (int i = 0; i < words.length; i++){
					wordCounter++;
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		int[] histogram = new int[wordCounter];
		List<String> words = new ArrayList<String>(wordCounter);
		
		try {
			br = new BufferedReader(new FileReader(fileName)); 		//add each word to 'words' holder
			String s;
			while ((s = br.readLine()) != null) {
				String[] splitArray = s.split(" |,");
				for (int i = 0; i < splitArray.length; i++) {
					words.add(splitArray[i]);
				}
			}
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		for (int i = 0; i < words.size(); i++) {				//finds number of occurrences of each word
			for (int j = 0; j < histogram.length; j++) {
				if (words.get(i).equals(words.get(j))) {
					histogram[j]++;
				}
			}
		}
		
		Set<String> uniqueWords = new TreeSet<String>();		//Collection to hold unique word/occurrences
		for (int i = 0; i < histogram.length; i++) {
			if (histogram[i] != 1) {
				uniqueWords.add(new String("'"+words.get(i))+"' appears " + histogram[i] + " times");
			}
		}
	
	for (String s : uniqueWords) {
		System.out.println(s);
	}
	
	}
	
	public static void main(String[] args) {
		wordsRepeatedInAFileWithOccurrences(FILENAME);
	}
	
}

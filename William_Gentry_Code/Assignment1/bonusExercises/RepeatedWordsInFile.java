package bonusExercises;
import java.io.*;
import java.util.*;

public class RepeatedWordsInFile {
	
	
	/*
	 * 
	 * 
	 *  This code properly counts the repeated words in a file,
	 *  however it prints each occurrence of the word with quantity
	 *  too many times
	 *  
	 *  
	 *  Will be fixed for the Saturday assignment
	 * 
	 * 
	 * 
	 */

	
	public static int[] numAppearancesOfWordInFile(String fileName) {
		int wordCounter = 0;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String s;
			while ((s = br.readLine()) != null) {
				String[] words = s.split(" ");
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
			br = new BufferedReader(new FileReader(fileName)); 
			String s;
			while ((s = br.readLine()) != null) {
				String[] splitArray = s.split(" ");
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
		
		
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < histogram.length; j++) {
				if (words.get(i).equals(words.get(j))) {
					histogram[j]++;
				}
			}
		}
		return histogram;
	}
	
	public static List<String> wordsInFile(String fileName) {
		int wordCounter = 0;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String s;
			while ((s = br.readLine()) != null) {
				String[] words = s.split(" ");
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
			br = new BufferedReader(new FileReader(fileName)); 
			String s;
			while ((s = br.readLine()) != null) {
				String[] splitArray = s.split(" ");
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
		
		
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < histogram.length; j++) {
				if (words.get(i).equals(words.get(j))) {
					histogram[j]++;
				}
			}
		}
		return words;
	}
	
	
	public static void repeatedWordsInFile(String fileName) {
		int[] histogram = numAppearancesOfWordInFile(fileName);
		List<String> words = wordsInFile(fileName);
		
		for (int i = 0; i < histogram.length; i++) {
			if (histogram[i] > 1) {
				System.out.println("'"+words.get(i).toString() + "' appears " + histogram[i] + " times");
			}
		}
	}
	
	public static void main(String[] args) {
		repeatedWordsInFile("src/bonusExercises/LoremIpsum.txt");
	}
	
}

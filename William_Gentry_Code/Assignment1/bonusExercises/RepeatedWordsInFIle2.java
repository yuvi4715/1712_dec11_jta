package bonusExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepeatedWordsInFIle2 {

	
	public static void numAppearancesOfWordInFile(String fileName) {
		int wordCounter = 0;
		
		BufferedReader br = null;
		BufferedReader br2 = null;
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
	}
	
	
}

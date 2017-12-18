package questions54;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RepeatedWordsInFile {

	FileReader fr;
	BufferedReader br;
	HashMap<String, Integer> countWords = new HashMap<String, Integer>();
	StringTokenizer st;
	public static void main(String[] args) throws IOException {
		RepeatedWordsInFile rwif = new RepeatedWordsInFile();
		rwif.initFileRead();
		rwif.getRepeatedWords();
		
	}

	public void initFileRead() throws FileNotFoundException {
		fr = new FileReader("resources/WordCount.txt");
		br = new BufferedReader(fr);
	}
	
	public void getRepeatedWords() throws IOException{
		String temp;
		while((temp = br.readLine()) != null) {
			
			st = new StringTokenizer(temp, " ,:\".()");
			while(st.hasMoreTokens()) {
				temp = st.nextToken();
				if(countWords.containsKey(temp)) {
					Integer tempNum = countWords.get(temp) + 1;
					countWords.put(temp, tempNum);
				}
				else {
					countWords.put(temp, 1);
				}
			}
		}
		for(String key : countWords.keySet()) {
			System.out.printf("Word: %s \t\tTimes Written: %d \n", key, countWords.get(key));
		}
		br.close();
		fr.close();
	}
}

package Bonus;

import java.io.*;
import java.util.ArrayList;
public class StringDupes {
	
	private static String line = null;
	private static final ArrayList<String> letterCheck = new ArrayList<>();

	public static void main(String[] args) {
		
		readFile();
		
	}
	
	
	
	private static void readFile() {
		FileReader fis = null;
		BufferedReader buffreader = null;
		
		try {
			fis = new FileReader("src/main/resources/BunchOfWords.txt");
			buffreader = new BufferedReader(fis);
			while((line = buffreader.readLine()) != null) {
				
				if(letterCheck.contains(line)) {
					System.out.println("Found String dupe: " + line);
				}
				else {
					letterCheck.add(line);
				}
				
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(buffreader != null) {
				try {
					buffreader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}

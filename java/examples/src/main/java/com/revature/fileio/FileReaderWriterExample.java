package com.revature.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {

	FileReader fr = null;
	FileWriter fw = null;
	 int c;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileReaderWriterExample f1 = new FileReaderWriterExample();
		f1.readChar();
		f1.writeChar();
	}
	
	void readChar() throws FileNotFoundException, IOException {
		fr = new FileReader("src\\main\\resources\\DummyData.txt");
		while ((c = fr.read()) != -1) {
			System.out.println(c);
		}
		fr.close();
	}
	
	void writeChar() throws FileNotFoundException, IOException {
		fw = new FileWriter("src\\main\\resources\\outputFile.txt");
		for (int i=47; i< 140; i++) {
			fw.write(i);
		}
		fw.close();
	}

}

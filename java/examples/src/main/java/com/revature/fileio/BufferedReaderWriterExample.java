package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExample {

	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new BufferedReaderWriterExample().readWriteValues();
	}

	void readWriteValues() throws FileNotFoundException, IOException{
		br = new BufferedReader(new FileReader("src\\main\\resources\\DummyData.txt"));
		bw = new BufferedWriter(new FileWriter("src\\main\\resources\\outputFile.txt"));
		String s;
		while((s= br.readLine()) != null) {
			bw.write(s);
		}
		br.close();
		bw.close();
	}
}

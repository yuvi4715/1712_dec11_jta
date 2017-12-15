package question24_25_26_27_28;


import java.io.IOException;

public class FileIOMain {

	public static void main(String[] args) throws IOException {
		FileIO fileToHash = new FileIO();

		fileToHash.initFileRead();
		fileToHash.readObjectIntoHashMap();
		fileToHash.printHashMap();
		fileToHash.fr.close();
	}

}

package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIO {	//#24-28
	public void fileparse(String filename) throws FileNotFoundException, IOException {
	    File file = new File(filename);
		FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
	    
	    while((line = br.readLine()) != null){
	            System.out.println(line);
	            StringTokenizer st1 = new StringTokenizer(line, ":");
	            Employee employee = new Employee(Integer.parseInt(st1.nextToken()), 
	            		st1.nextToken(), st1.nextToken(), st1.nextToken());	//should be checked...
	            map.put(employee.employeeID, employee); //#28
	    }
	    
	    /*
	    for (int i: map.keySet()) {
	    	System.out.println("id: " + i + " " + map.get(i).role);
	    }*/
	    
	    br.close();
	    fr.close();
	}
}

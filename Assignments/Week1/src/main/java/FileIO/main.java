package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class main {
	static Employee emp1 = new Employee();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//application is not meant for multiple employees, just a proof of concept

		new main().fileReader("src/main/resources/Employee.txt");
		new main().printEmployees();

	}
	
	private void fileReader(String file) {
		String line = null;
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(reader);
			
			while((line = bufreader.readLine()) != null) {
				StringTokenizer stringToken = new StringTokenizer(line, ":");
				
				while(stringToken.hasMoreElements()) {
					
					String key = stringToken.nextToken().toString();
					String value = stringToken.nextToken().toString();
					
					//System.out.println(key);
					
					if (key.equals("Employee ID")) {
						emp1.setEmployeeID(Integer.parseInt(value));
					}
					
					if (key.equals("First Name")) {
						emp1.setEmployeeFirstName(value);	
					}
					if (key.equals("Last Name")) {
						emp1.setEmployeeLastName(value);
					}
					
					if(key.equals("Role")) {
						emp1.setEmployeeRole(value);
					}
					
				}

			}
			bufreader.close();
			
		}
		catch(FileNotFoundException  ex){
			System.out.println(ex.getMessage());
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}

	}

	private void printEmployees() {
		HashMap hmap = new HashMap<>();
		
		hmap.put("Employee Id", emp1.getEmployeeID());
		hmap.put("First Name", emp1.getEmployeeFirstName());
		hmap.put("Last Name", emp1.getEmployeeLastName());
		hmap.put("Role", emp1.getEmployeeRole());
		
		for(Object y : hmap.keySet()) {
			System.out.printf("%s : %s\n",y,hmap.get(y));
		}
		
	}
}
